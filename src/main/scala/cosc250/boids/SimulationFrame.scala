package cosc250.boids

/** Represents the state in our simulation.
  *
  * A simulation frame contains an immutable sequence of Boids. It has methods
  * for reporting various measures about the boids in the frame. It has a method
  * for producing a new simulation frame
  */
case class SimulationFrame(boids: Seq[Boid]) {

  /** The current average direction of the flock. Add up all the boids' velocity
    * vectors, and take the theta.
    */
  def flockDir: Double = {
    boids.averageVelocity.theta
  }

  /** The current average speed of the flock. Take the mean of all the boids'
    * velocity magnitudes.
    */
  def flockSpeed: Double = {
    boids.averageVelocity.magnitude
  }

  /** The variance of the flock's positions, ignoring the fact we wrap around
    * the screen. To get this one: * Calculate the centroid of the flock (Add
    * all the position vectors, and divide by the number of boids) * Calculate
    * the square of the distance of each boid from this centroid, and sum them.
    * i.e., sum Math.pow((b.position - centroid).magnitude, 2) * Divide this by
    * the number of boids.
    *
    * We'll probably eyeball the code for this one, given we're going to find it
    * harder to eyeball whether the number on the screen looks right!
    */
  def flockSep: Double = {
    boids
      .map(b =>
        Math.pow((b.position - boids.centroid).magnitude, 2) / boids.size
      )
      .sum
  }

  /** This function should calculate the next set of boids assuming there is no
    * wind & no one-time functions applied
    */
  def nextBoids(wind: Vec2): Seq[Boid] = {
    (boids.map(x => x.update(x.flock(boids), wind))).toSeq
  } // for eavery boid update it to find next position and velocity

  /** @param wind
    *   \- a force applied to every boid. We've called it "wind" but in
    *   practice, it'll steer the flock.
    * @param oneTimeFunction
    *   \- a function to apply to every boid (e.g. startle).
    * @return
    */
  def nextFrame(
      wind: Vec2,
      oneTimeFunction: Option[Boid => Vec2] = None
  ): SimulationFrame = {
    return SimulationFrame(nextBoids(wind))
  }
}
object SimulationFrame {

  /** Generates boids in the centre of the simulation, moving at v=1 in a random
    * direction
    */
  def explosionOfBoids(i: Int): SimulationFrame = {
    SimulationFrame(
      List
        .range(0, i)
        .map(_ =>
          new Boid(
            Vec2(
              SimulationController.width / 2,
              SimulationController.height / 2
            ),
            Vec2.randomDir(2)
          )
        )
        .toSeq
    )
  }
}

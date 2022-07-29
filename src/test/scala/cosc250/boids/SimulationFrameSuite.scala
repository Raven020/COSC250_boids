package cosc250.boids

/** SimulationFrames are immutable data classes with functions to methods to
  * produce new immutable values. They are eminently testable - although you
  * will probably want to use a small number of boids (e.g. 2 or 3) in your
  * tests.
  */
class SimulationFrameSuite extends munit.FunSuite {

  // A place for you to write tests

  val boid1 = new Boid(Vec2(1.0, 2.0), Vec2(13.0, 15.0))
  val boid2 = new Boid(Vec2(3, 4), Vec2(13, 14))
  val boid3 = new Boid(Vec2(2.1, 4.1), Vec2(13, 14))
  val boid4 = new Boid(Vec2(10, 15), Vec2(15, 16))
  val allBoids: SimulationFrame = new SimulationFrame(
    Seq(boid1, boid2, boid3, boid4)
  )

  test("flockDir should Calculate Average flock direction") {
    assertEquals(allBoids.flockDir, 0.8296171077931012)
  }

  test("flockSpeed should Calculate Average flock speed") {
    assertEquals(allBoids.flockSpeed, 19.99531195055481)
  }
}

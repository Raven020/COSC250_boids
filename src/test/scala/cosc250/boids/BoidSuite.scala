package cosc250.boids

/** A place for you to write some boid tests.
  *
  * Boids are an immutable class containing functions. That makes them
  * relatively straightforward to test -- except that the values within them are
  * doubles, which are hard to compare exactly. Instead, test if they are close
  * (i.e. within a certain amount +/- what you're looking for).
  */
class BoidSuite extends munit.FunSuite {

  // A place for you to write tests. Some suggested tests to start with have been sketched below

  // Let's start with the extension methods closeTo, centroid and averageVelocity on Seq[Boid]...
  val boid1 = new Boid(Vec2(1.0, 2.0), Vec2(-13.0, -15.0))

  val boid2 = new Boid(Vec2(3, 4), Vec2(13, 14))
  val boid3 = new Boid(Vec2(2.1, 4), Vec2(13, 14))
  val boid4 = new Boid(Vec2(10, 15), Vec2(15, 16))
  val boid5 = new Boid(Vec2(100, 150), Vec2(150, 160))
  val boids = Seq(boid1, boid2, boid3, boid4, boid5)

  test(
    "align should be able to calculate vector to align direction with other boids"
  ) {
    assertEquals(
      boid1.align(boids),
      Vec2(0.02005508787868903, 0.02231128526504155)
    )
  }
  val target = Vec2(1, 5)
  test(
    "separate should be able to calculate vector away from other boids"
  ) {
    assertEquals(
      boid1.seek(target),
      Vec2(0.021213203435596427, 0.021213203435596423)
    )
  }
}

package cosc250.boids

/** A place for you to write some boid tests.
  *
  * Boids are an immutable class containing functions. That makes them
  * relatively straightforward to test -- except that the values within them are
  * doubles, which are hard to compare exactly. Instead, test if they are close
  * (i.e. within a certain amount +/- what you're looking for).
  */
class SeqBoidSuite extends munit.FunSuite {

  // A place for you to write tests. Some suggested tests to start with have been sketched below

  // Let's start with the extension methods closeTo, centroid and averageVelocity on Seq[Boid]...
  val boid1 = new Boid(Vec2(1.0, 2.0), Vec2(13.0, 15.0))

  val boid2 = new Boid(Vec2(3, 4), Vec2(13, 14))
  val boid3 = new Boid(Vec2(2.1, 4), Vec2(13, 14))
  val boid4 = new Boid(Vec2(10, 15), Vec2(15, 16))
  val boid5 = new Boid(Vec2(100, 150), Vec2(150, 160))
  val boids1 = Seq(boid1, boid2, boid3, boid4, boid5)

  test("Seq[Boid] should be able to calculate its centroid") {
    assertEquals(boids1.centroid, Vec2(23.22, 35))
  }

  test("Seq[Boid] should be able to calculate its average velocity") {
    assertEquals(boids1.averageVelocity, Vec2(40.8, 43.8))
  }

}

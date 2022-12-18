package challenges

import cats.effect.unsafe.implicits.global
import doodle.image.Image
import doodle.core.*
import doodle.syntax.all.*
import doodle.image.syntax.all.*
import doodle.reactor.*
import doodle.java2d.*

object RocketShip {
  // Defines the outline of the rocket ship
  val shipOutline = {
    import PathElement.*
    val leftSide = Seq(moveTo(0, 0), curveTo(-20, -30, -40, -60, -30, -120))
    val bottom = Seq(curveTo(-15, -100, 15, -100, 30, -120))
    val rightSide = Seq(curveTo(40, -60, 20, -30, 0, 0))
    Image.closedPath(leftSide ++ bottom ++ rightSide)
  }

  // Create an image for the portholes, given an alpha (value for transparency)
  def portholes(alpha: Normalized) =
    Image
      .circle(10)
      .at(0, -25)
      .on(Image.circle(30).at(0, -55))
      .on(Image.circle(10).at(0, -85))
      .fillColor(Color.white.alpha(alpha))

  // Create an image for the ship, given an alpha (value for transparency)
  def ship(alpha: Normalized) =
    portholes(alpha)
      .on(shipOutline.fillColor(Color.crimson.alpha(alpha)))
      .strokeColor(Color.black.alpha(alpha))
      .strokeWidth(5.0)

  // Create the image of the ship during the countdown (fading in)
  def drawCountdown(count: Int): Image = {
    val alpha = ((100 - count).toDouble / 100.0).normalized
    ship(alpha).at(startingPoint)
  }

  // Create the image of the ship flying (moving up the screen)
  def drawFlying(location: Point): Image = {
    ship(Normalized.MaxValue).at(location)
  }

  // Implement this.
  //
  // The State is either
  // - Countdown, containing an integer, the counts left
  // - Flying, containing a Point, the location of the rocket ship
  type State = Nothing

  // The place the ship starts at
  val startingPoint = Point(0, -280)
  // The velocity that the ship moves with
  val velocity = Vec(0, 20)

  // Implement this.
  //
  // If the state is Countdown, and the count is zero, the result should be a
  // Flying ship, starting at startingPoint. Otherwise the result should be
  // Countdown with the count decremented by one.
  //
  // If the state is Flying, the result if Flying with a position equal to the
  // current position plus velocity.
  def nextState(state: State): State =
    ???

  // Implement this.
  //
  // Given the state, create the image using drawCountdown and drawFlying above.
  def draw(state: State): Image =
    ???

  // Implement this.
  //
  // Is true when the ship is Flying and location's y value is >= 540
  def finished(state: State): Boolean =
    ???

  val animation =
    Reactor
      .init(
        // Implement this.
        //
        // The initial state should be Countdown with 100 counts left. 
        // If you followed the specification to the letter this should just work.
        State.Countdown(100)
      )
      .withOnTick(nextState)
      .withRender(draw)
      .withStop(finished)

  // Run this to see the rocket ship take off!
  @main def toTheStars =
    animation.run(Frame.size(200, 800).background(Color.midnightBlue))
}

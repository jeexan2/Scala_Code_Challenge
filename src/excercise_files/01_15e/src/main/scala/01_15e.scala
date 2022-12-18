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

  def portholes(alpha: Normalized) =
    Image
      .circle(10)
      .at(0, -25)
      .on(Image.circle(30).at(0, -55))
      .on(Image.circle(10).at(0, -85))
      .fillColor(Color.white.alpha(alpha))

  def ship(alpha: Normalized) =
    portholes(alpha)
      .on(shipOutline.fillColor(Color.crimson.alpha(alpha)))
      .strokeColor(Color.black.alpha(alpha))
      .strokeWidth(5.0)

  def drawCountdown(count: Int): Image = {
    val alpha = ((100 - count).toDouble / 100.0).normalized
    ship(alpha).at(startingPoint)
  }

  def drawFlying(location: Point): Image = {
    ship(Normalized.MaxValue).at(location)
  }

  enum State {
    case Countdown(number: Int)
    case Flying(location: Point)
  }

  val startingPoint = Point(0, -280)
  val velocity = Vec(0, 20)

  def nextState(state: State): State =
    state match {
      case State.Countdown(n) =>
        if n <= 0 then State.Flying(startingPoint)
        else State.Countdown(n - 1)

      case State.Flying(pt) => State.Flying(pt + velocity)
    }

  def draw(state: State): Image =
    state match {
      case State.Countdown(n) => drawCountdown(n)

      case State.Flying(pt) => drawFlying(pt)
    }

  def finished(state: State): Boolean =
    state match {
      case State.Countdown(_) => false

      case State.Flying(pt) => pt.y >= 540
    }

  val animation =
    Reactor
      .init(State.Countdown(100))
      .withOnTick(nextState)
      .withRender(draw)
      .withStop(finished)

  @main def go =
    animation.run(Frame.size(200, 800).background(Color.midnightBlue))
}

package challenges

import cats.effect.unsafe.implicits.global
import doodle.image.Image
import doodle.core.Color
import doodle.image.syntax.all.*
import doodle.java2d.*

object Sierpinski {
  val triangle = Image.equilateralTriangle(10).fillColor(Color.pink)

  def sierpinski(depth: Int): Image =
    ???

  @main def drawSierpinski(): Unit =
    sierpinski(5).draw()
}

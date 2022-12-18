package challenges

import cats.effect.unsafe.implicits.global
import doodle.image.Image
import doodle.core.Color
import doodle.image.syntax.all.*
import doodle.java2d.*

object Sierpinski {
  val triangle = Image.equilateralTriangle(10).fillColor(Color.pink)

  def sierpinski(depth: Int): Image =
    if depth == 0 then triangle.above(triangle.beside(triangle))
    else
      sierpinski(depth - 1).above(
        sierpinski(depth - 1).beside(sierpinski(depth - 1))
      )

  @main def drawSierpinski(): Unit =
    sierpinski(5).draw()
}

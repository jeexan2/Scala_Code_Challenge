package challenges

import cats.effect.unsafe.implicits.global
import doodle.image.Image
import doodle.core.Color
import doodle.image.syntax.all.*
import doodle.java2d.*
import scala.annotation.tailrec

object ColoredBlocks {
  // The block used to create the stack of blocks
  val block = Image.square(40).fillColor(Color.crimson)

  // Example showing how to create a stack of blocks
  val stack = block.above(block.above(Image.empty))

  @tailrec
  def helper(count: Int, image: Image): Image =
    if (count == 0) image
    else
      helper(count - 1, block.above(image))

  def stack(count: Int): Image =
    helper(count, Image.empty)

  // Call this to draw a stack of blocks
  @main def drawBlocks(): Unit =
    stack(5).draw()
}

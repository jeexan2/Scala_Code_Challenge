package challenges

import munit.*
import doodle.image.Image

class ColoredBlocksSuite extends FunSuite {
  test("stack correctly constructs a stack of blocks") {
    assertEquals(ColoredBlocks.stack(0), Image.empty)
    assertEquals(ColoredBlocks.stack(1), ColoredBlocks.block.above(Image.empty))
    assertEquals(
      ColoredBlocks.stack(2),
      ColoredBlocks.block.above(ColoredBlocks.block.above(Image.empty))
    )
    assertEquals(
      ColoredBlocks.stack(3),
      ColoredBlocks.block.above(
        ColoredBlocks.block.above(ColoredBlocks.block.above(Image.empty))
      )
    )
  }
}

package challenges

import munit.*
import doodle.image.Image

class SnakesAndCamelsSuite extends FunSuite {
  test("initial letter is unchanged") {
    assertEquals(SnakesAndCamels.snakeToCamel("a"), "a")
    assertEquals(SnakesAndCamels.snakeToCamel("b"), "b")
    assertEquals(SnakesAndCamels.snakeToCamel("C"), "C")
    assertEquals(SnakesAndCamels.snakeToCamel("D"), "D")
  }

  test("word following _ is capitalized") {
    assertEquals(SnakesAndCamels.snakeToCamel("a_man"), "aMan")
    assertEquals(SnakesAndCamels.snakeToCamel("a_plan"), "aPlan")
    assertEquals(SnakesAndCamels.snakeToCamel("one_egg"), "oneEgg")
    assertEquals(SnakesAndCamels.snakeToCamel("is_Enough"), "isEnough")
  }

  test("Non-alphabetic characters are left alone") {
    assertEquals(SnakesAndCamels.snakeToCamel("1_egg"), "1Egg")
    assertEquals(SnakesAndCamels.snakeToCamel("A_4"), "A4")
  }

  test("All words are processed") {
    assertEquals(
      SnakesAndCamels.snakeToCamel("a_man_a_plan_a_canal_panama_!"),
      "aManAPlanACanalPanama!"
    )
    assertEquals(
      SnakesAndCamels.snakeToCamel("hypertext_markup_language"),
      "hypertextMarkupLanguage"
    )
  }
}

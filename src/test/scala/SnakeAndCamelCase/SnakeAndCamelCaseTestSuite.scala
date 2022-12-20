package SnakeAndCamelCase

import munit.FunSuite
import snake_camel_case.SnakeToCamelCase

class SnakeAndCamelCaseTestSuite extends FunSuite{
  test("initial letter is unchanged") {
    assertEquals(SnakeToCamelCase.snakeToCamelCase("a"), "a")
    assertEquals(SnakeToCamelCase.snakeToCamelCase("b"), "b")
    assertEquals(SnakeToCamelCase.snakeToCamelCase("C"), "C")
    assertEquals(SnakeToCamelCase.snakeToCamelCase("D"), "D")
  }

  test("word following _ is capitalized") {
    assertEquals(SnakeToCamelCase.snakeToCamelCase("a_man"), "aMan")
    assertEquals(SnakeToCamelCase.snakeToCamelCase("a_plan"), "aPlan")
    assertEquals(SnakeToCamelCase.snakeToCamelCase("one_egg"), "oneEgg")
    assertEquals(SnakeToCamelCase.snakeToCamelCase("is_Enough"), "isEnough")
  }

  test("Non-alphabetic characters are left alone") {
    assertEquals(SnakeToCamelCase.snakeToCamelCase("1_egg"), "1Egg")
    assertEquals(SnakeToCamelCase.snakeToCamelCase("A_4"), "A4")
  }

  test("All words are processed") {
    assertEquals(
      SnakeToCamelCase.snakeToCamelCase("a_man_a_plan_a_canal_panama_!"),
      "aManAPlanACanalPanama!"
    )
    assertEquals(
      SnakeToCamelCase.snakeToCamelCase("hypertext_markup_language"),
      "hypertextMarkupLanguage"
    )
  }
}

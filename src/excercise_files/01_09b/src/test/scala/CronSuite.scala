package challenges

import munit.*

class CronSuite extends FunSuite {
  import Time.*

  test("All stars is parsed correctly") {
    val result = Cron.parse("* * * * * echo 'Hello'")

    assertEquals(result, CronLine(All, All, All, All, All, "echo 'Hello'"))
  }

  test("All numbers is parsed correctly") {
    val result = Cron.parse("15 2 3 4 2 echo 'Hello'")

    assertEquals(
      result,
      CronLine(At(15), At(2), At(3), At(4), At(2), "echo 'Hello'")
    )
  }

  test("Mixture of number and star is parsed correctly") {
    val result = Cron.parse("15 * 3 * * echo 'Hello'")

    assertEquals(
      result,
      CronLine(At(15), All, At(3), All, All, "echo 'Hello'")
    )
  }
}

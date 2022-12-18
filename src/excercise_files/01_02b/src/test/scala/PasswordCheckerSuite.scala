package challenges

import munit.*

class PasswordCheckerSuite extends FunSuite {
  test("Acceptable passwords are ok") {
    assert(PasswordChecker.isValidPassword("(ScalaChallenge2)"))
    assert(PasswordChecker.isValidPassword("b3stpAssw0rd!"))
    assert(PasswordChecker.isValidPassword("qu1zL_ts"))
  }

  test("Unacceptable passwords are not ok") {
    assert(!PasswordChecker.isValidPassword("z1x:bN"))
    assert(!PasswordChecker.isValidPassword("qWeRtYuI"))
    assert(!PasswordChecker.isValidPassword("quizzle123"))
  }
}

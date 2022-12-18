package password_checker

import munit._

// Acceptable passwords: b3stpAssw0rd! , qu1zL_ts
// Unacceptable passwords: z1x:bN , qWeRtYuI , quizzle123
class PasswordCheckerSuite extends FunSuite{
    test("Password Checker is working correctly!"){
        assert(PasswordChecker.isValidPassword("b3stpAssw0rd!"))
        assert(PasswordChecker.isValidPassword("qu1zL_ts"))
        assert(!PasswordChecker.isValidPassword("z1x:bN"))
        assert(!PasswordChecker.isValidPassword("qWeRtYuI"))
        assert(!PasswordChecker.isValidPassword("quizzle123"))
    }

}

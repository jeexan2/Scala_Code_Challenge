package palindrome_a

import munit._

class PalindromeAsuite extends FunSuite{
  test("Palindromes are correctly identified") {
    assert(Palindrome.isPalindrome("kayak"))
    assert(Palindrome.isPalindrome("level"))
    assert(Palindrome.isPalindrome("radar"))
  }

  test("Non-palindromes are correctly identified") {
    assert(!Palindrome.isPalindrome("canoe"))
    assert(!Palindrome.isPalindrome("bumpy"))
    assert(!Palindrome.isPalindrome("lidar"))
  }

  test("Case is ignored") {
    assert(Palindrome.isPalindrome("tacocat"))
    assert(Palindrome.isPalindrome("TACOCAT"))
    assert(Palindrome.isPalindrome("tacoCAT"))
  }
}

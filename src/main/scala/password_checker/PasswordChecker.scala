package password_checker

//Requirements
// 1. Must be a sting
// 2. Password must be at least 8 characters long
// 3. Password must contain at least one upper case letter
// 4. Password must contain at least one lower case letter
// 5. Password must contain at least one number or one punctuation character

// Punctuation characters are: . , ; : ? ! " _ ) (

object PasswordChecker {
  val punctuations: List[String]  = List(".",","," ;", ":", "?", "!","\"","_","(",")")
//  def hasPunctuation(word: String) : Boolean =
//    word.exists(char => punctuations.contains(char))
  
  def isDigitOrPunctuation(word: String) : Boolean =
    word.exists(char => char.isDigit || punctuations.contains(char))
    
  def isValidPassword(password: String) : Boolean =
    password.size >= 8 &&
      password.exists(_.isUpper) &&
      password.exists(_.isLower) &&
      isDigitOrPunctuation(password)
}

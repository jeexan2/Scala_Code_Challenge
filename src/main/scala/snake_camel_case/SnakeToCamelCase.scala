package snake_camel_case

//Remove underscores and capitalize the next letter
//use regex to find substring
object SnakeToCamelCase {
  def snakeToCamelCase(s: String): String = {
    val snakeWordToRegex = "_(.)".r
    snakeWordToRegex.replaceAllIn(s, m => m.group(1).toUpperCase)
  }
}
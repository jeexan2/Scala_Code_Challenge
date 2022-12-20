package snake_camel_case

//Remove underscores and capitalize the next letter
//use regex to find substring
object SnakeToCamelCase {
  def snakeToCamelCase(s: String): String = {
    val snakeWordToRegex = "_(.)".r
    snakeWordToRegex.replaceAllIn(s, m => m.group(1).toUpperCase)

  }

  def snakeToCamelCaseAlternateLogic(s:String) =
    s.split("_").map(_.capitalize).mkString("")

  def main(args: Array[String]): Unit = {
    println(snakeToCamelCase("snake_case"))
    println(snakeToCamelCaseAlternateLogic("snake_case"))
  }
}
package challenges

object SnakesAndCamels {
  def snakeToCamel(string: String): String = {
    val snakeWordRegex = "_(.)".r

    snakeWordRegex.replaceAllIn(
      string,
      matched => matched.group(1).toUpperCase
    )
  }
}

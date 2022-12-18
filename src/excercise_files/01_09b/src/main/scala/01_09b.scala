package challenges

enum Time {
  case All
  case At(value: Int)
}
object Time {
  def fromString(input: String): Time =
    input match {
      case "*"    => All
      case number => At(number.toInt)
    }
}

final case class CronLine(
    minute: Time,
    hour: Time,
    day: Time,
    month: Time,
    dayOfWeek: Time,
    command: String
)

object Cron {
  def parse(input: String): CronLine =
    ???
}

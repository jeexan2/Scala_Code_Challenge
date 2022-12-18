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
  val Line =
    raw"(\d*|\*) (\d*|\*) (\d*|\*) (\d*|\*) (\d*|\*) (.*)".r

  def parse(input: String): CronLine =
    input match {
      case Line(minute, hour, day, month, dayOfWeek, command) =>
        CronLine(
          Time.fromString(minute),
          Time.fromString(hour),
          Time.fromString(day),
          Time.fromString(month),
          Time.fromString(dayOfWeek),
          command
        )
    }
}

package challenges

import scala.sys.SystemProperties

object Properties {
  def printAll(): Unit =
    new SystemProperties().iterator.foreach((name, value) =>
      println(s"$name: $value")
    )
}

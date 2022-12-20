package find_system_property_value

import scala.sys.SystemProperties

object Properties {
  def printAll(): Unit =
    new SystemProperties().iterator.foreach {
      case (key, value) => println(s"$key = $value")

    }

  def main(args: Array[String]): Unit = {
    printAll()
  }

}

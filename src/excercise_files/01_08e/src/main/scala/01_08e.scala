package challenges

import scala.util.Random

object Pi extends App {
  def pi(iterations: Long): Double = {
    def loop(inside: Long, total: Long): Double =
      if total == iterations then (4.0 * inside.toDouble / total.toDouble)
      else {
        val x = Random.nextDouble - 0.5
        val y = Random.nextDouble - 0.5

        val dist = math.sqrt((x * x) + (y * y))

        if dist < 0.5 then loop(inside + 1, total + 1)
        else loop(inside, total + 1)
      }

    loop(0, 0)
  }

  println(pi(100000))
}

package challenges

sealed trait Resistor {
  def resistance: Double
  def tolerance: Double
}

enum E6(val resistance: Double) extends Resistor {
  val tolerance = 0.2

  case TenOhm extends E6(10.0)
  case FifteenOhm extends E6(15.0)
  case TwentyTwoOhm extends E6(22.0)
  case ThirtyThreeOhm extends E6(33.0)
  case FortySevenOhm extends E6(47.0)
  case SixtyEightOhm extends E6(68.0)
}

enum E12(val resistance: Double) extends Resistor {
  val tolerance = 0.1

  case TenOhm extends E12(10.0)
  case TwelveOhm extends E12(12.0)
  case FifteenOhm extends E12(15.0)
  case EighteenOhm extends E12(18.0)
  case TwentyTwoOhm extends E12(22.0)
  case TwentySevenOhm extends E12(27.0)
  case ThirtyThreeOhm extends E12(33.0)
  case ThirtyNineOhm extends E12(39.0)
  case FortySevenOhm extends E12(47.0)
  case FiftySixOhm extends E12(56.0)
  case SixtyEightOhm extends E12(68.0)
  case EightyTwoOhm extends E12(82.0)
}

object Resistance {
  def range(resistors: List[Resistor]): (Double, Double) =
    resistors.foldLeft((0.0, 0.0)) { (accum, resistor) =>
      val (lower, upper) = accum

      val lo = resistor.resistance * (1.0 - resistor.tolerance)
      val hi = resistor.resistance * (1.0 + resistor.tolerance)

      (lower + lo, upper + hi)
    }
}

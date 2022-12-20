package ResistorTolerance

sealed trait Resistor {
  def resistance: Double
  def tolerance: Double
}

//enum E6(val resistance: Double) extends Resistor {
//  val tolerance = 0.2
//
//  case TenOhm extends E6(10.0)
//  case FifteenOhm extends E6(15.0)
//  case TwentyTwoOhm extends E6(22.0)
//  case ThirtyThreeOhm extends E6(33.0)
//  case FortySevenOhm extends E6(47.0)
//  case SixtyEightOhm extends E6(68.0)
//}


object Resistor {

}

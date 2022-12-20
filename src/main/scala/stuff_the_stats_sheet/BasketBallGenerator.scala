package stuff_the_stats_sheet

import doodle.random.*
enum Event {
  def player: String

  def team: String

  def make: Boolean =
    this match {
      case _: TwoPtMake => true
      case _: ThreePtMake => true
      case _ => false
    }

  case TwoPtMake(player: String, team: String)
  case TwoPtMiss(player: String, team: String)
  case ThreePtMake(player: String, team: String)
  case ThreePtMiss(player: String, team: String)
  case OffensiveRebound(player: String, team: String)
  case DefensiveRebound(player: String, team: String)
}

final case class Team(name: String, players: List[Player])
final case class Player(
                         name: String,
                         twoPointPercentage: Double,
                         threePointPercentage: Double,
                         twoPointPropensity: Double
                       )

object BasketBallGenerator {
  val defensiveReboundPropensity: Double = 0.7
  val gameLength: Int = 120

  val birmingham = Team("Birmingham Basketballers",
      List(
        Player("Jimothy Dunkin", 0.65, 0.3, 0.9),
        Player("Timmy Butler", 0.58, 0.33, 0.8),
        Player("Modula Siakam", 0.52, 0.35, 0.7),
        Player("Danny Red", 0.48, 0.38, 0.6),
        Player("Stephen Gumbo", 0.55, 0.42, 0.4)
      )
  )

  val highbury =
    Team(
      "Highbury Hoopers",
      List(
        Player("Nicolas Joker", 0.62, 0.35, 0.9),
        Player("Mini Kleber", 0.58, 0.3, 0.85),
        Player("Osaka Bryant", 0.5, 0.37, 0.65),
        Player("Oskar Rupertson", 0.52, 0.4, 0.6),
        Player("Paul Chris", 0.5, 0.37, 0.6)
      )
    )

  def shotEvent(team:String,player: Player): Random[Event] =
    ???

  def reboundEvent(offense: Team,defense: Team): Random[Event] =
    ???

  def posessionEvents(offense: Team,defense: Team): Random[List[Event]] =
    ???

  def gameEvents(
                count: Int,
                offense: Team,
                defense: Team
                ): Random[List[Event]] =
    ???
}



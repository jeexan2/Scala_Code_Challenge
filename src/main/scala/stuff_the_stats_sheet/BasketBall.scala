package stuff_the_stats_sheet

final case class StatLine(
  player: String,
  twoPointMakes: Int,
  twoPointAttempts: Int,
  threePointMakes: Int,
  threePointAttempts: Int,
  offensiveRebounds: Int,
  defensiveRebounds: Int){

  def addTwoPointMake: StatLine = this.copy(
    twoPointMakes = twoPointMakes + 1,
    twoPointAttempts = twoPointAttempts + 1
  )

  def addTwoPointAttempt: StatLine = this.copy(
    twoPointAttempts = twoPointAttempts + 1
  )

  def addThreePointMake: StatLine = this.copy(
    threePointMakes = threePointMakes + 1,
    threePointAttempts = threePointAttempts + 1
  )

  def addThreePointAttempt: StatLine = this.copy(
    threePointAttempts = threePointAttempts + 1
  )

  def addOffensiveRound: StatLine = this.copy(
    offensiveRebounds = offensiveRebounds + 1
  )

  def addDefensiveRound: StatLine = this.copy(
    defensiveRebounds = defensiveRebounds + 1
  )
}

final case class BoxScore(home: List[StatLine], away: List[StatLine])
object BasketBall {
  def makeStatLine(player: String, events: List[Event]): StatLine =
    events.foldLeft(StatLine(player, 0, 0, 0, 0, 0, 0)) { (stats, event) =>
      event match {
        case _: Event.TwoPtMake => stats.addTwoPointMake
        case _: Event.TwoPtMiss => stats.addTwoPointAttempt
        case _: Event.ThreePtMake => stats.addThreePointMake
        case _: Event.ThreePtMiss => stats.addThreePointAttempt
        case _: Event.OffensiveRebound => stats.addOffensiveRound
        case _: Event.DefensiveRebound => stats.addDefensiveRound
      }
    }
  def boxScore(
                home: String,
                away: String,
                events: List[Event]
              ): BoxScore = {
    val eventsByTeam: Map[String, List[Event]] = events.groupBy(e => e.team)
    val homeByPlayers: Map[String, List[Event]] = eventsByTeam(home).groupBy(e => e.player)
    val awayByPlayers: Map[String, List[Event]] = eventsByTeam(away).groupBy(e => e.player)

    val homeStats = homeByPlayers.map((player, events) => makeStatLine(player, events))
    val awayStats = awayByPlayers.map((player, events) => makeStatLine(player, events))

    BoxScore(homeStats.toList, awayStats.toList)
  }
  // Run this to see an example
  @main def exampleGame: BoxScore = {
    val events =
      BasketBallGenerator
        .gameEvents(
          120,
          BasketBallGenerator.birmingham,
          BasketBallGenerator.highbury
        )
        .run

    BasketBall.boxScore(
      BasketBallGenerator.birmingham.name,
      BasketBallGenerator.highbury.name,
      events
    )
  }
}

package challenges

final case class StatLine(
    player: String,
    twoPointMakes: Int,
    twoPointAttempts: Int,
    threePointMakes: Int,
    threePointAttempts: Int,
    offensiveRebounds: Int,
    defensiveRebounds: Int
) {
  def addTwoPointMake: StatLine =
    this.copy(
      twoPointMakes = twoPointMakes + 1,
      twoPointAttempts = twoPointAttempts + 1
    )

  def addTwoPointAttempt: StatLine =
    this.copy(
      twoPointAttempts = twoPointAttempts + 1
    )

  def addThreePointMake: StatLine =
    this.copy(
      threePointMakes = threePointMakes + 1,
      threePointAttempts = threePointAttempts + 1
    )

  def addThreePointAttempt: StatLine =
    this.copy(
      threePointAttempts = threePointAttempts + 1
    )

  def addOffensiveRebound: StatLine =
    this.copy(offensiveRebounds = offensiveRebounds + 1)

  def addDefensiveRebound: StatLine =
    this.copy(defensiveRebounds = defensiveRebounds + 1)
}

final case class BoxScore(home: List[StatLine], away: List[StatLine])

object Basketball {
  def makeStatLine(player: String, events: List[Event]): StatLine =
    events.foldLeft(StatLine(player, 0, 0, 0, 0, 0, 0)) { (stats, event) =>
      event match {
        case _: Event.TwoPtMake        => stats.addTwoPointMake
        case _: Event.TwoPtMiss        => stats.addTwoPointAttempt
        case _: Event.ThreePtMake      => stats.addThreePointMake
        case _: Event.ThreePtMiss      => stats.addThreePointAttempt
        case _: Event.OffensiveRebound => stats.addOffensiveRebound
        case _: Event.DefensiveRebound => stats.addDefensiveRebound
      }
    }

  def boxScore(
      home: String,
      away: String,
      events: List[Event]
  ): BoxScore = {
    val eventsByTeam: Map[String, List[Event]] = events.groupBy(evt => evt.team)
    val homeByPlayers: Map[String, List[Event]] =
      eventsByTeam(home).groupBy(evt => evt.player)
    val awayByPlayers: Map[String, List[Event]] =
      eventsByTeam(away).groupBy(evt => evt.player)

    val homeStats =
      homeByPlayers.map((player, events) => makeStatLine(player, events))
    val awayStats =
      awayByPlayers.map((player, events) => makeStatLine(player, events))

    BoxScore(homeStats.toList, awayStats.toList)
  }

  def example: BoxScore = {
    val events =
      BasketballGenerator
        .gameEvents(
          120,
          BasketballGenerator.birmingham,
          BasketballGenerator.highbury
        )
        .run

    Basketball.boxScore(
      BasketballGenerator.birmingham.name,
      BasketballGenerator.highbury.name,
      events
    )
  }
}

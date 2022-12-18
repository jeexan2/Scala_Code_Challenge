package challenges

import scala.util.Random

object ReservoirSampling {
  final case class State[A](result: Option[A], count: Int)
  object State {
    def empty[A]: State[A] = State(None, 0)
  }

  def sample[A](elts: List[A]): Option[A] = {
    val State(result, _) =
      elts.foldLeft(State.empty[A]) { (state, elt) =>
        val State(result, count) = state
        if Random.nextDouble < (1.0 / (count + 1).toDouble)
        then State(Some(elt), count + 1)
        else State(result, count + 1)
      }

    result
  }
}

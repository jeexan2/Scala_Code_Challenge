package decision_tree

enum DecisionTree {
  def decide(value:Int): Boolean =
    this match{
      case Result(result) => result
      case Split(split,lte,gt) => 
        if value <= split then lte.decide(value)
        else gt.decide(value)
    }
  case Result(result: Boolean)
  case Split(
            split:Int,
            lessThanOrEqual: DecisionTree,
            greaterThan: DecisionTree
            )
}
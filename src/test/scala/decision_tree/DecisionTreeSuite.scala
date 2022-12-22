package decision_tree

import munit.FunSuite

class DecisionTreeSuite extends FunSuite {
  test("sampling empty list returns None") {
    import DecisionTree.*
    val tree =
      Split(
        4,
        Split(2, Result(false), Result(true)),
        Split(6, Result(false), Result(true))
      )

    test("elements are assigned to the expected buckets") {
      assert(!tree.decide(0))
      assert(!tree.decide(1))
      assert(!tree.decide(2))
      assert(tree.decide(3))
      assert(tree.decide(4))
      assert(!tree.decide(5))
      assert(!tree.decide(6))
      assert(tree.decide(7))
      assert(tree.decide(8))
    }
  }
}
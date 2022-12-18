package challenges

import munit.*

class CalculatorSuite extends FunSuite {
  test("literals evaluate to themselves") {
    assertEquals(Eval(Expression(1.0)), 1.0)
    assertEquals(Eval(Expression(3.0)), 3.0)
    assertEquals(Eval(Expression(5.0)), 5.0)
    assertEquals(Eval(Expression(7.0)), 7.0)
  }

  test("complex expressions evaluate correctly") {
    assertEquals(Eval(Expression(1.0) + Expression(3.0)), 4.0)
    assertEquals(Eval(Expression(1.0) * Expression(3.0)), 3.0)
    assertEquals(Eval(Expression(4.0) / Expression(2.0) + Expression(2.0)), 4.0)
    assertEquals(Eval(Expression(1.0) * Expression(3.0) - Expression(2.0)), 1.0)
  }
}

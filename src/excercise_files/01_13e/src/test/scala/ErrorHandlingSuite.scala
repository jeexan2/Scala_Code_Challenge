package challenges

import munit.*
import challenges.Store.Fulfillment

class ErrorHandlingSuite extends FunSuite {
  test("Successful order fulfilled as expected") {
    val result = Store.processOrderForUser(1)
    assertEquals(result, Some(Fulfillment("Today")))
  }

  test("Unsuccessful orders fail") {
    assertEquals(Store.processOrderForUser(0), None)
    assertEquals(Store.processOrderForUser(2), None)
    assertEquals(Store.processOrderForUser(3), None)
    assertEquals(Store.processOrderForUser(4), None)
  }
}

package org.ravi

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by ravikupin on 26/1/16.
 */

class BasicExpressionParserSpec extends FlatSpec with Matchers with BasicExpressionParser {
  "Parse" should "parse simple additions of two variables" in {
    parseAll(expr, "3 + 5").successful shouldBe true
  }

  it should "subtract two variables" in {
    parseAll(expr, "3 - 5").successful shouldBe true
  }
}

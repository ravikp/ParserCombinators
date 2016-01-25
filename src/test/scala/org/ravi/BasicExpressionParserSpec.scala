package org.ravi

import org.scalatest.{FlatSpec, Matchers}

/**
 * Created by ravikupin on 26/1/16.
 */

class BasicExpressionParserSpec extends FlatSpec with Matchers with BasicExpressionParser {
  "Parser" should "parse simple additions of two variables" in {
    val actual: ParseResult[Tree] = parseAll(expr, "3 + 5")
    actual.successful shouldBe true
    actual.get shouldBe a [Tree]
    eval(actual.get) shouldBe 8
  }

  it should "subtract two variables" in {
    val parseResult = parseAll[Tree](expr, "3 - 5")
    parseResult.successful shouldBe true
    eval(parseResult.get) shouldBe -2
  }

  it should "add and subtract more than two variables" in {
    parseAll(expr, "2 + 3 - 4 + 10").successful shouldBe true
  }

  it should "parse expressions with parenthesis" in {
    parseAll(expr, "(2-3)").successful shouldBe true
  }

  it should "parse expressions with multiplication" in {
    parseAll(expr, "2 * (1 + 3)").successful shouldBe true
  }

  it should "parse expressions with division" in {
    parseAll(expr, "2 * 5 / (1 + 3)").successful shouldBe true
  }
}

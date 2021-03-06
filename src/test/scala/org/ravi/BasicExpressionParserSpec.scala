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
    val result: ParseResult[Tree] = parseAll[Tree](expr, "2 + 3 - 4 + 10")
    result.successful shouldBe true
    eval(result.get) shouldBe 11
  }

  it should "parse expressions with parenthesis" in {
    val result = parseAll[Tree](expr, "(2-3)")
    result.successful shouldBe true
    eval(result.get) shouldBe -1
  }

  it should "parse expressions with multiplication" in {
    val result = parseAll[Tree](expr, "2 * (1 + 3)")
    result.successful shouldBe true
    eval(result.get) shouldBe 8
  }

  it should "parse expressions with division" in {
    val result = parseAll[Tree](expr, "2 * 5 / (1 + 3)")
    result.successful shouldBe true
    eval(result.get) shouldBe 2
  }
}

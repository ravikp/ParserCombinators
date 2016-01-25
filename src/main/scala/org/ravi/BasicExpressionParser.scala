package org.ravi

import scala.util.parsing.combinator.JavaTokenParsers

/**
 * Created by ravikupin on 26/1/16.
 */
trait BasicExpressionParser extends JavaTokenParsers{

  def expr:Parser[Any] = muldiv ~ rep("+" ~ muldiv | "-" ~ muldiv)

  def muldiv = factor ~ rep("[*/]".r ~ factor) | factor

  def factor = wholeNumber | "(" ~ expr ~ ")"

}

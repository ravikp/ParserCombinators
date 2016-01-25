package org.ravi

import scala.util.parsing.combinator.JavaTokenParsers

/**
 * Created by ravikupin on 26/1/16.
 */
trait BasicExpressionParser extends JavaTokenParsers{

  def expr:Parser[Int] = muldiv ~ rep("+" ~ muldiv | "-" ~ muldiv) ^^ {x => 0}

  def muldiv:Parser[Int] = factor ~ rep("[*/]".r ~ factor) ^^ {x => 0} | factor

  def factor:Parser[Int] = wholeNumber ^^ {_.toInt} | "(" ~> (expr <~ ")")

}

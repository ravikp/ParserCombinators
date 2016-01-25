package org.ravi

import scala.util.parsing.combinator.JavaTokenParsers

/**
 * Created by ravikupin on 26/1/16.
 */
trait BasicExpressionParser extends JavaTokenParsers{

  def expr:Parser[Any] = wholeNumber ~ rep("+" ~ wholeNumber | "-" ~ wholeNumber)

}

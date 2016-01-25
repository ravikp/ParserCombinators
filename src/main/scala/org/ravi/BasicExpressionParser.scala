package org.ravi

import scala.util.parsing.combinator.JavaTokenParsers

/**
 * Created by ravikupin on 26/1/16.
 */
trait BasicExpressionParser extends JavaTokenParsers{

  def expr:Parser[Tree] = muldiv ~ rep("+" ~ muldiv | "-" ~ muldiv) ^^ {x => Leaf(0)}

  def muldiv:Parser[Tree] = factor ~ rep("[*/]".r ~ factor) ^^ {x => Leaf(0)} | factor

  def factor:Parser[Tree] = wholeNumber ^^ {x => Leaf(x.toInt)} | "(" ~> (expr <~ ")")

  sealed abstract class Tree
  case class Leaf(weight: Int) extends Tree

  def eval(tree: Tree):Int = ???

}

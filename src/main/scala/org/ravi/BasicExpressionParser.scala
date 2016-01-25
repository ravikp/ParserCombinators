package org.ravi

import scala.util.parsing.combinator.JavaTokenParsers

/**
 * Created by ravikupin on 26/1/16.
 */
trait BasicExpressionParser extends JavaTokenParsers{

  def expr:Parser[Tree] = muldiv ~ rep("+" ~ muldiv | "-" ~ muldiv) ^^ {
    case x ~ xs => xs.foldLeft(x) {
      case (a, "+" ~ b) => Add(a, b)
      case (a, "-" ~ b) => Sub(a, b)
    }
  }

  def muldiv:Parser[Tree] = factor ~ rep("[*/]".r ~ factor) ^^ {
    case x ~ xs => xs.foldLeft(x){
      case (a, "*" ~ b) => Mul(a, b)
      case (a, "/" ~ b) => Div(a, b)
    }
  }

  def factor:Parser[Tree] = wholeNumber ^^ {x => Leaf(x.toInt)} | "(" ~> (expr <~ ")")

  sealed abstract class Tree
  case class Add(left: Tree, right:Tree) extends Tree
  case class Sub(left: Tree, right:Tree) extends Tree
  case class Mul(left: Tree, right:Tree) extends Tree
  case class Div(left: Tree, right:Tree) extends Tree
  case class Leaf(weight: Int) extends Tree

  def eval(tree: Tree):Int = tree match {
    case Add(l, r) => eval(l) + eval(r)
    case Sub(l, r) => eval(l) - eval(r)
    case Mul(l, r) => eval(l) * eval(r)
    case Div(l, r) => eval(l) / eval(r)
    case Leaf(w) => w
  }

}

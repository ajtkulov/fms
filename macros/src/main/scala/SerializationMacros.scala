package macros

import scala.annotation.StaticAnnotation
import scala.collection.immutable.TreeSet
import scala.language.experimental.macros
import scala.reflect.macros.{Universe, Context, whitebox}
//import scala.language.experimental.macros

trait Method {
  def method: Int
}

trait Inner {
  def method: String
}

object SerializationMacros {
  def gen: Method = macro impl
  def gen1[A]: Inner = macro impl1[A]

  def impl(c: whitebox.Context): c.Expr[Method] = {
    import c.universe._
    c.Expr {
      q"""
      class test extends macros.Method {
      def method:Int = 1
      }
      new test {}"""
    }
  }

  def impl1[A: c.WeakTypeTag](c: whitebox.Context): c.Expr[Inner] = {
    import c.universe._

    val clazz = weakTypeOf[A].typeSymbol.asClass

//    val info: List[List[c.universe.Symbol]] = clazz.primaryConstructor.typeSignature.paramLists
    val info: List[List[c.universe.Type]] = clazz.primaryConstructor.typeSignature.paramLists.map(x => x.map(x => x.typeSignature))
    val qq = info.toString

//    val symbol: String = weakTypeOf[A].typeSymbol.asClass.toString
//    val symbol: String = weakTypeOf[A].typeSymbol.asClass.toString
//    val symbol: String = weakTypeOf[A].decls.toString
//    val symbol: String = weakTypeOf[A].members.toString
    val symbol: String = weakTypeOf[A].paramLists.toString


    c.Expr[Inner] {
      q"""
      class test1 extends macros.Inner {
        def method:String = $qq
      }
      new test1 {}
        """
    }
  }
}

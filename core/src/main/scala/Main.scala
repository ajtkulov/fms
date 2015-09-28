import macros.SerializationMacros

/**
 * Created by pavel on 29/09/15.
 */
object Main extends App {
  override def main(args: Array[String]): Unit = {
    val q = SerializationMacros.gen
    println(q)
    println(q.method)

    val q1 = SerializationMacros.gen1[Int]
    println(q1)
    println(q1.method)
  }
}

import macros.SerializationMacros

case class Some1(value1: Int, value2: String)

object Main extends App {
  override def main(args: Array[String]): Unit = {
    val q = SerializationMacros.gen
    println(q)
    println(q.method)

    val q1 = SerializationMacros.gen1[Some1]
    println(q1)
    println(q1.method)
  }
}

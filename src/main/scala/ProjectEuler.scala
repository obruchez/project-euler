package projecteuler

object ProjectEuler {
  def main(args: Array[String]) {
    if (args.length != 1) {
      println("Usage: ProjectEuler <problem number>")
    } else {
      try {
        Class.forName("projecteuler.P"+args(0)).newInstance.asInstanceOf[{ def solve(): Unit }].solve()
      } catch {
        case e: Exception =>
          println("Problem "+args(0)+" not found ("+e+")")
      }
    }
  }
}

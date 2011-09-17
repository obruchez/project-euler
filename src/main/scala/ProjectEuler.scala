package projecteuler

object ProjectEuler {
  def main(args: Array[String]) {
    if (args.length != 1) {
      println("Usage: ProjectEuler <problem number>")
    } else {
      try {
        val start = System.nanoTime()
        Class.forName("projecteuler.P"+args(0)).newInstance.asInstanceOf[{ def solve(): Unit }].solve()
        val elapsedTimeInSec = (System.nanoTime() - start) * 1.0e-9
        println("Elapsed time: "+elapsedTimeInSec+" sec")
      } catch {
        case e: Exception =>
          println("Problem "+args(0)+" not found ("+e+")")
      }
    }
  }
}

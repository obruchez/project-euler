package projecteuler

import annotation.tailrec

/*
If we list all the natural numbers below 10 that are multiples of 3 or 5, we get 3, 5, 6 and 9. The sum of these multiples is 23.

Find the sum of all the multiples of 3 or 5 below 1000.
 */

class P1 {
  def solve() {
    val limit = 1000

    @tailrec def markMultiples(from: Int, step: Int, markers: Set[Int] = Set()): Set[Int] =
      if (from >= limit)
        markers
      else
        markMultiples(from + step, step, markers + from)

    val answer = (markMultiples(3, 3) ++ markMultiples (5, 5)).fold(0)(_ + _)
    println(answer)
  }
}

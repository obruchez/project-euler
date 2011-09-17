package projecteuler

import annotation.tailrec

/*
The prime factors of 13195 are 5, 7, 13 and 29.

What is the largest prime factor of the number 600851475143 ?
 */

class P3 {
  def solve() {
    def isPrime(number: Long): Boolean = {
      @tailrec def isCandidatePrime(number: Long, factorCandidate: Long): Boolean =
        if (number % factorCandidate == 0)
          if (factorCandidate == 1) true else false
        else
          isCandidatePrime(number, factorCandidate - 1)
      isCandidatePrime(number, math.sqrt(number).toLong + 1)
    }

    def largestFactor(number: Long): Long = {
      @tailrec def largestFactorForCandidate(number: Long, factorCandidate: Long): Long =
        if (number % factorCandidate == 0 && isPrime(factorCandidate))
          factorCandidate
        else
          largestFactorForCandidate(number, factorCandidate - 1)
      largestFactorForCandidate(number, math.sqrt(number).toLong + 1)
    }

    val answer = largestFactor(600851475143L)
    println(answer)
  }
}
package leetCode

object ClimbingStairs extends App {

  def rec(n: Int): Int = {

    if (n <= 1) return n;

    else {
      return rec(n - 2) + rec(n - 1)
    }

  }
  def climbStairs(n: Int): Int = {

    if (n == 1) return 1
    else {
      return rec(n + 1)
    }
  }
  println(climbStairs(20))
}
package leetCode

object LIS extends App {

  def lengthOfLIS(nums: Array[Int]): Int = {

    val lis = Array.fill(nums.length)(1)

    if (nums.isEmpty) return 0 else if (nums.length == 1) return 1

    for (i <- 1 to nums.length - 1) {

      for (j <- 0 to i - 1) {

        // println(i, j)

        if (nums(i) > nums(j) && lis(i) < lis(j) + 1)

          lis(i) = ( lis(j) + 1 )
      }
    }
    lis.max
  }

  val input = Array(1, 3, 6, 7, 9, 4, 10, 5, 6)
  val res = lengthOfLIS(input)
  println(res)
}
package leetCode

object TrappingRainWater extends App {

  def trap(height: Array[Int]): Int = {

    if (height.length < 3) return 0;

    val arrayLength = height.length
    var maxRight = height.takeRight(arrayLength - 2).max
    var maxLeft = height(0)

    var trappedSum = 0

    for (i <- 1 to arrayLength - 2) {

      maxRight = if (height(i) == maxRight) height.takeRight(arrayLength - (i + 1)).max else maxRight
      val sum = (Math.min(maxRight, maxLeft) - height(i))
      if (sum > 0) trappedSum = trappedSum + sum
      maxLeft = Math.max(height(i), maxLeft)
    }
    trappedSum
  }

  println(trap(Array(0)))

}
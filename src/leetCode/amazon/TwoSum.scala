package leetCode.amazon

/*
Given nums = [2, 7, 11, 15], target = 9,
Because nums[0] + nums[1] = 2 + 7 = 9,
return [0, 1]
*/
object TwoSum extends App {

  def twoSum(nums: Array[Int], target: Int): Array[Int] = {

    val numsSorted = nums.sorted

    numsSorted.zipWithIndex.map { n =>

      val elem = n._1
      val index = n._2
      
      var diff = target - elem

      //println(diff)
      var currentValue = elem
      var i = index + 1

      while (currentValue <= diff && i < numsSorted.length) {
        currentValue = numsSorted(i)
        if (currentValue == diff) return Array(nums.indexOf(elem), nums.lastIndexOf(currentValue))
        i += 1
      }

    }

    Array(-1, -1)
  }

  val inputArray = Array(-1,-1,-2,-3,-4,-5)

  val res = twoSum(inputArray, -2)

  res.foreach(println)

}
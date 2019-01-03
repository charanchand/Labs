package leetCode
import scala.collection.mutable.ListBuffer

/**
 * Given a sorted integer array nums, where the range of elements are in the inclusive range [lower, upper], return its missing ranges.
 * Example:
 * Input: nums = [0, 1, 3, 50, 75], lower = 0 and upper = 99,
 * Output: ["2", "4->49", "51->74", "76->99"]
 */

object MissingIntervals extends App {

  def findMissingRanges(nums: Array[Int], lower: Int, upper: Int): List[String] = {
    val arrBuff = new ListBuffer[String]

    val numsWithBounds = Array(lower) ++ nums ++ Array(upper + 1)

    numsWithBounds.zipWithIndex.map { ci =>

      var currElement = ci._1
      var currIndex = ci._2
      
      if(currIndex == numsWithBounds.length - 1) return arrBuff.toList

      if ((currElement + 1) != numsWithBounds(currIndex + 1)) {

        if(currElement == numsWithBounds(currIndex + 1)) None        
        else if (numsWithBounds(currIndex + 1) - currElement == 2) arrBuff += (currElement + 1).toString
        else arrBuff += (currElement + 1) + "->" + (numsWithBounds(currIndex + 1) - 1)
      }
    }
    arrBuff.toList
  }

  val nums = Array(0, 1, 3, 50, 75)
  
  println(findMissingRanges(nums, 0, 99))

}
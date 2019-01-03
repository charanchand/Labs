package leetCode
import scala.collection.mutable.HashMap
object LongestSubString extends App {

  def lengthOfLongestSubstring(s: String) : Int 
  = {

    var startIndex = 0
    var maxLength = 0
    val visitedChars = new HashMap[Char, Int]()
    for ((c, i) <- s.zipWithIndex) {

      if (!(visitedChars contains c)) {
        visitedChars(c) = i
      } else {
        val currLength = i - startIndex
        if (currLength > maxLength) maxLength = currLength
        startIndex = visitedChars(c) + 1
        visitedChars.retain { (k, v) => v >= startIndex }
        visitedChars(c) = i
      }
    }
    Math.max(maxLength, s.length - startIndex)
  }

  val result = lengthOfLongestSubstring("ohomm")
  println(result)
}
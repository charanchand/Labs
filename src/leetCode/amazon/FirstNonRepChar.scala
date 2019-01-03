package leetCode.amazon
import scala.collection.mutable.ListBuffer

object FirstNonRepChar extends App {
  val visitedChars = new ListBuffer[Char]

  def firstUniqChar(s: String): Int = {

    s.zipWithIndex.map { c =>

      if (!visitedChars.contains(c._1)) {

        val nextIndex = s.indexOf(c._1, c._2 + 1)

        if (nextIndex == -1) return c._2

        else visitedChars += c._1
      }
    }

    -1
  }

  println(firstUniqChar("ffooffbb"))
  visitedChars.foreach(println)
}
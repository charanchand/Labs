package leetCode

object ZIgZagConv extends App {

  def zigZag(s: String, numRows: Int): String = {

    var (slope, index) = (0, 0)

    val zigzagStrings = Array.fill[String](numRows)("")

    if ((s.length < numRows) || numRows == 1) return s

    else {
      for (c <- s) {

        zigzagStrings(index) += c

        if (index == 0) slope = 1

        else if (index == numRows - 1) slope = -1

        index += slope

      }
      return zigzagStrings.mkString
    }

  }

  println(zigZag("CA", 1))
}
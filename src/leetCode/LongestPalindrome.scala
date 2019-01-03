package leetCode

object LongestPalindrome extends App {

  def longestPalindrome(s: String): String = {

    val longPal = if (s.length == 1) s
    else {
      val extPalindromes = (for {
        i <- (s.size to 1 by -1);

        str <- s.sliding(i)

        if str == str.reverse

      } yield str)

      if (!extPalindromes.isEmpty) extPalindromes.maxBy(x => x.size) else ""

    }
    longPal
  }

  println(longestPalindrome("babad"))
}
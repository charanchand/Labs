package leetCode

object ValidPalindrome extends App {

  def isPalindrome(s: String): Boolean = {
    val validStr = s.replaceAll("[^A-Za-z0-9]", "")
    if (validStr.equalsIgnoreCase(validStr.reverse)) return true else false;
  }

}
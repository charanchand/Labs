package leetCode.amazon

import scala.collection.mutable.ListBuffer
object ReverseString extends App {

  //Input:  ["t","h","e"," ","s","k","y"," ","i","s"," ","b","l","u","e"]
  //Output: ["b","l","u","e"," ","i","s"," ","s","k","y"," ","t","h","e"]

  val reverseChars = new ListBuffer[Char]

  def reverseWords(str: Array[Char]): Unit = {

    val inpStr = str.mkString.split(" ")

    for (i <- (inpStr.size - 1) to 0 by -1) {
      
      inpStr(i).map(c => reverseChars += c)

      if (i != 0) reverseChars += ' '
    }
  }

  val inpArr = Array('t', 'h', 'e', ' ', 's', 'k', 'y')

  reverseWords(inpArr)

  reverseChars.foreach(println)
  
  println(reverseChars.length)
}
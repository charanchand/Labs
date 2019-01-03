package leetCode
import scala.annotation.tailrec

/*1.     1
2.     11
3.     21
4.     1211
5.     111221*/

object CountAndSay extends App {

  def countAndSay(n: Int): String = {

    if (n == 1) return "1" else if (n == 2) return "21"

    val StringApp = new StringBuilder()

    var prevIter = "21"

    for (i <- 3 to n) { //can be n + 1
    
      StringApp.clear()
      val prevIterArr = prevIter.split("")
      

      for (j <- 0 to prevIterArr.length - 2) {

        var count = 1
        val ce = prevIterArr(j)

        if (ce == prevIterArr(j + 1)) count += 1

        else {
          StringApp.append(count).append(ce); count = 1
        }
      }
      prevIter = StringApp.mkString
    }
    prevIter
  }
  
  countAndSay(4)

}
/* 
  loop(10, "1")
 
  @tailrec
  private def loop(n: Int, num: String): Unit = {
    println(num)
    if (n <= 0) () else loop(n - 1, lookandsay(num))
  }
 
  private def lookandsay(number: String): String = {
    val result = new StringBuilder
 
    @tailrec
    def loop(numberString: String, repeat: Char, times: Int): String =
      if (numberString.isEmpty) result.toString()
      else if (numberString.head != repeat) {
        result.append(times).append(repeat)
        loop(numberString.tail, numberString.head, 1)
      } else loop(numberString.tail, numberString.head, times + 1)
 
    loop(number.tail + " ", number.head, 1)
  }*/
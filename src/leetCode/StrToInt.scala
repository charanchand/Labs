package leetCode
import scala.util.control.Breaks._
import scala.collection.mutable.ArrayBuffer

object StrToInt extends App {

  def myAtoi(str: String): Int = {
    val trimmedStr = str.replace(" ", "")
    val intBuffer = new ArrayBuffer[Char]()

    if (trimmedStr.isEmpty()) return 0;

    if ((trimmedStr(0).isDigit) || (trimmedStr(0) == '-') || (trimmedStr(0) == '+')) intBuffer += trimmedStr(0) else return 0;

    breakable {
      trimmedStr.tail.map { c =>
        if (c.isDigit) intBuffer += c
        else break;
      }
    }

    val resStr = intBuffer.mkString
    if ((resStr == "-") || (resStr == "+")) return 0;

    resStr.toLong match {
      case n if n > Int.MaxValue => Int.MaxValue
      case n if n < Int.MinValue => Int.MinValue
      case n                     => n.toInt
    }

   /* try { resStr.toInt } catch {
      case e: Exception => Integer.MIN_VALUE
    } */
  }

  println(myAtoi("20000000000"))
}

//arrayBuffer1 += "Vanilla Donut"
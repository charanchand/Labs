
import scala.util.control.Breaks._

object codilityPrac {

  //[1, 3, 6, 4, 1, 2]

  def majorityElement(inpArr: Array[Int]) : Int 
  = {
    inpArr.foreach(println)

    var maxcount = 0

    var maxElement = 0

    inpArr.map { i =>

      val elementCount = inpArr.count(_ == i)

      if (elementCount > maxcount) { maxcount = elementCount; maxElement = i }
    }

   if (maxcount > (inpArr.length / 2)) maxElement else -1

  }
  def main(args: Array[String]) {
    var ok = true
    
    while (ok) {
      val ln = readLine()
      ok = ln != null
      if (ok) println(ln)
    }
    
    
    
    
  }
    
}
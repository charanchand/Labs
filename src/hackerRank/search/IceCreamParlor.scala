package hackerRank.search
import scala.collection.Searching._
import scala.util.control.Breaks._

object IceCreamParlor extends App {

  import _root_.scala.collection.JavaConversions._
  import java.util.{ Collections, List => JList }
  
  class SearchableSeq[T](a: Seq[T])(implicit ordering: Ordering[T]) {
    val list: JList[T] = a.toList
    def binarySearch(key: T): Int = Collections.binarySearch(list, key, ordering)
  }
  /*
  def whatFlavors(cost: Array[Int], money: Int) = {

    val sortedCost = cost.sorted
    var costPair = Seq(0, 0)
    
    breakable {
      cost.map { e =>

        println(e)
        implicit def seqToSearchable[T](a: Seq[T])(implicit ordering: Ordering[T]) = 
        new SearchableSeq(a)(ordering)
        
        val eindex = sortedCost.binarySearch(money - e)
        
        Collections.binarySearch(sortedCost.toList, e)

        println("eindex: " + eindex)

        if (eindex < sortedCost.length) {
          costPair = Seq(cost.indexOf(e) + 1, eindex + 1)
          break
        }
      }
    }
    println(costPair.max + " " + costPair.min)
  } */

 // val result = whatFlavors(Array(1, 2, 3, 5, 6), 5)

  
}
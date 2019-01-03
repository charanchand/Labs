package leetCode
import scala.collection.mutable.ListBuffer

object GroupAnagrams extends App {

  def groupAnagrams(input: Array[String]): List[List[String]] = {

    val finalList = new ListBuffer[List[String]]
    
    val bar = input.map { w => (w -> w.sorted) }.groupBy(_._2)
    
    bar.mapValues(_.foreach(println))
   
     input.map { w => (w -> w.sorted) }.groupBy(_._2) .mapValues(_.map(x => x._1)).mapValues(x => finalList += x.toList)
     
    finalList.toList
  }
    
  val result = groupAnagrams(Array("abdc", "noep", "bacd"))
  
  result.foreach(_.foreach(println))

}
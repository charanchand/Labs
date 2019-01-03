package challenge42
import scala.collection.mutable.ListBuffer
import scala.io.Source

object HierarchicalSort extends App {

  val outputList = new ListBuffer[String]
  case class InputSchema(var property0: String, var property1: String, var property2: String, var metric: Double)
  case class CustomException(msg: String) extends Exception(msg)

  /**
   * Custom toHead implicit method
   * Makes sure that specified string is placed at the top of the collection, gives priority to record which has both the fields as specified string
   */
  implicit class RichList[A](val inp: List[(String, String, Double)]) extends AnyVal {
    def toHead(e: String) = {
      val (eq, neq) = inp.partition(row => (row._2 == e))
      //val (eq1, eq2) = neq.partition(row => row._2 == e)
      eq ++ neq
    }
  }

  def hierarchicalSort(input: List[HierarchicalSort.InputSchema]) = {

    //  Ranks top level category according to metric total -- Map(0 -> womens footwear, 1 -> mens footwear)
    val prop0Ranked = input.filter(x => x.property1 == "$total").filterNot(x => x.property0 == "$total" && x.property1 == "$total" && x.property2 == "$total")
      .sortBy(r => -r.metric).map { r => r.property0 }.zipWithIndex.map { case (element, index) => (index, element) }.toMap

    //Map of top level category and sorted sub categories
    val categSorted = input.groupBy(r => r.property0).mapValues(r => r.map(r => (r.property1, r.property2, r.metric)).sortBy(r => (-r._3, r._2)).sortBy(r => r._1))

    //appends sorted categories according the ronk to the output list
    for (i <- 0 to prop0Ranked.size - 1) {
      val prop0 = prop0Ranked(i)
      outputList += categSorted(prop0).map(x => prop0 + "|" + x._1 + "|" + x._2 + "|" + x._3).mkString("\n")
    }
  }
  val inputDataLocation = args(0)
  val inputMetric = args(1)

  val lines = Source.fromFile(inputDataLocation).getLines.toList
  val headers = lines.head.split("\\|")
  val metricIndex = headers.indexOf(inputMetric)

  if (metricIndex == -1) throw new CustomException("Invalid input metric") //throws exception if specified metric is not present in the header

  //Defining schema for input
  val input = lines.tail.map { line => val spLine = line.split("\\|"); new InputSchema(spLine(0), spLine(1), spLine(2), spLine(metricIndex).toDouble) }

  val grandTotal = input.filter(x => x.property0 == "$total" && x.property1 == "$total" && x.property2 == "$total").map { r => r.property0 + "|" + r.property1 + "|" + r.property2 + "|" + r.metric }.mkString
  outputList += grandTotal

  //Sorts the collection and writes to outputList
  hierarchicalSort(input)

  outputList.foreach(println)
}
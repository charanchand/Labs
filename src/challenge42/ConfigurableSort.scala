package challenge42
import scala.collection.mutable.ListBuffer
import scala.io.Source

object ConfigurableSort extends App {

  val outputList = new ListBuffer[String]
  case class CustomException(msg: String) extends Exception(msg)

  // implementation to apply implicit Ordering to dynamic number of elements in the list
  def orderList[T](implicit ord: Ordering[T]): Ordering[List[T]] = new Ordering[List[T]] {
    def compare(x: List[T], y: List[T]): Int = {
      (x, y) match {
        case (Nil, Nil) => 0
        case (Nil, _)   => -1
        case (_, Nil)   => 1
        case (xhead :: xtail, yhead :: ytail) => {
          val headdiff = ord.compare(xhead, yhead)
          if (headdiff == 0) compare(xtail, ytail)
          else (headdiff)
        }
      }
    }
  }

  def configurableSort(input: List[Array[String]]) = {

    //  Ranks top level category according to metric total -- Map(0 -> womens footwear, 1 -> mens footwear)
    val prop0Ranked = input.filter(x => x(1) == "$total").filterNot(x => x.forall(_ == "$total")).sortBy(r => -r(r.length - 1).toInt).map(r => r(0))
      .zipWithIndex.map { case (element, index) => (index, element) }.toMap

    //Map of top level category and sorted sub categories
    val categSorted = input.groupBy(r => r(0)).mapValues(r => r.map(r => (r.tail)).sortBy(r => (-r(r.length - 1).toInt, r(r.length - 2))).sortBy(r => r.take(r.length - 2).toList)(orderList))

    //appends sorted categories according the ronk to the output list
    for (i <- 0 to prop0Ranked.size - 1) {
      val prop0 = prop0Ranked(i)
      outputList += categSorted(prop0).map(x => prop0 + "|" + x.mkString("|")).mkString("\n")
    }
  }

  val inputDataLocation = args(0)
  val inputMetric = args(1)
  val lines = Source.fromFile(inputDataLocation).getLines.toList
  val headers = lines.head.split("\\|")

  val numOfProps = headers.filter(x => x.startsWith("property")).max.replace("property", "").toInt
  val metricIndex = headers.indexOf(inputMetric)
  if (metricIndex == -1) throw new CustomException("Invalid input metric") //throws exception if specified metric is not present in the header

  val input = lines.tail.map { line => val cols = line.split("\\|"); (cols.take(numOfProps + 1) ++ Array(cols(metricIndex))) }
  val grandTotal = input.filter(x => x.forall(_ == "$total")).map { r => r.mkString("|") }.mkString

  outputList += grandTotal
  configurableSort(input) // Sorts the collection with n properties(n >= 2) and metric specified
  outputList.foreach(println)
}
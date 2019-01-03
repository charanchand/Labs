package leetCode

object ElementsWith0Sum extends App {

  import scala.collection.mutable.ListBuffer

  def getTriplets(nums: Array[Int]): List[List[Int]] = {
    if (nums.size < 3) return List(List())

    val sList = nums.sorted

    val resList = new ListBuffer[List[Int]]

    for (i <- 0 to (sList.size - 2)) {

      var low = i + 1

      var high = sList.size - 1

      while (low < high) {

        val sum = sList(i) + sList(low) + sList(high)

        if (sum > 0) high -= 1

        else if (sum < 0) low += 1

        else {
          resList.append(List(sList(i), sList(low), sList(high)))

          high -= 1

          low += 1
        }
      }
    }

    resList.toList.distinct
  }

  val input = Array(-4, -2)
  val result = getTriplets(input)

  result.foreach(println)

}

//x.toList.groupBy(_._2).mapValues(_.map(_._1)).map{ case (x, y) => (y, x) }
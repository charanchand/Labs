
object RepeatedString extends App {

  // Complete the repeatedString function below.
  def sol(s: String, n: Long): Long = {

    val numOfA = s.count(_ == 'a')
    val numOfTimes = (n / s.length)
    val extString = (n % s.length)
    val addCnt = s.substring(0, extString.toInt).count(_ == 'a')
    (numOfA * numOfTimes) + addCnt

  }

  println(sol("aba", 10))
  println(sol("a", 1000000000000L))
}
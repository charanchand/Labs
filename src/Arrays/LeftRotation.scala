package Arrays

object LeftRotation extends App {

  def sol(a: Array[Int], d: Int): Array[Int] 
  = {
    val arrLen = a.length
    val divPnt = d % arrLen

    val arrToAppend = a.slice(0, divPnt)

    a.drop(arrToAppend.length) ++ arrToAppend
  }
  
  val ipArray = Seq(1, 2, 3 ,4 ,5).toArray

  sol(ipArray, 4).foreach(println)
  
}
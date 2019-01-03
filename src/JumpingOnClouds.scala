
import scala.util.control.Breaks._

object JumpingOnClouds extends App {

  //0 0 1 0 0 1 0
  //0 0 0
  def sol(c: Array[Int]) //: Int 
  = {
    var stepCounter = 0
    var cindex = 0

    if ((c.length > 2) && c(2) == 0) {
      cindex = 2; stepCounter = 1
    } else if (c(1) == 0) {
      cindex = 1
      stepCounter = 1
    } else if (c(0) == 0) {
      cindex = 0
      stepCounter = 0
    }
    breakable {
      while (cindex < c.length - 1) {
        if ((cindex + 2 < c.length) && c(cindex + 2) == 0) {

          stepCounter += 1
          cindex += 2
        } else if ((cindex + 1 < c.length) && c(cindex + 1) == 0) {

          stepCounter += 1
          cindex += 1
        } else {
          break
        }
      }
    }
    stepCounter
  }
  val inputArr = Seq(0, 0).toArray
  println(sol(inputArr))
}
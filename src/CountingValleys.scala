

object CountingValleys extends App {

  //UDUUUDUDDD

  def sol(n: Int, s: String) //: Int 
  = {
    var numValleys = 0
    var count = 0

    s.toArray.map { c =>

      if (c == 'U') count += 1 else count -= 1

      if ((count == 0) && (c == 'U')) {
        numValleys += 1
      }
    }

    numValleys
  }
  println("lol", sol(8, "DDUUDDUDUUUD"))
}

//// println(stoArr.subSequence(ci, stoArr.length).toString, stoArr.subSequence(ci, stoArr.length).toString.split("U").take(1).mkString.count(_ == 'D') )

/*    val stoArr = s.toArray
    var ci = 0
    var numValleys = 0
    var stepCount = 0
    while (ci < stoArr.length) {
      stepCount = 0
      s.substring(0, ci + 1).map { c => if (c == 'U') stepCount += 1 else stepCount -= 1 }
      if (stepCount < 0) {
        val DCnt = stoArr.subSequence(ci, stoArr.length).toString.split("U").take(1).mkString.count(_ == 'D')
        if (DCnt >= 2) { numValleys += 1; ci += DCnt } else ci += 1
      } else {
        ci += 1
      }
    }*/
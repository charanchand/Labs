package codility

object BinaryGap extends App {
  def solution(n: Int): Int = {

    val nInBin = n.toBinaryString

    var index = 0
    var maxZeros = 0
    
    while (index > -1) {

      val firIndex = nInBin.indexOf("1", index)
      val secIndex = nInBin.indexOf("1", firIndex + 1)

      if (firIndex > -1 && secIndex > -1) {
        val numOfZeros = nInBin.substring(firIndex + 1, secIndex).length
        if (numOfZeros > maxZeros) maxZeros = numOfZeros
      }
      index = secIndex

    }
    maxZeros
  }

  println(solution(66561))
}
/*     if (firIndex + 1 < nInBin.length && secIndex < nInBin.length) {
        val numOfZeros = nInBin.substring(firIndex + 1, secIndex).length
        println(nInBin.substring(firIndex + 1, secIndex))
        if (numOfZeros > maxZeros) {

          maxZeros = numOfZeros
        }
      }*/
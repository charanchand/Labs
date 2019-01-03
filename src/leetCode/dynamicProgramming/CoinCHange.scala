package leetCode.dynamicProgramming

object CoinCHange extends App {

  def coinChange(coins: Array[Int], amount: Int): Int = {

    if (coins.isEmpty) return -1

    val sortedCoins = coins.sortWith(_ > _)

    var rem = amount % sortedCoins(0)
    var numCoins: Int = (amount / sortedCoins(0))

    if (rem == 0) return numCoins
    else {

      for (i <- 1 to sortedCoins.length - 1) {

        val currRum:Int = rem % sortedCoins(i)

        numCoins += (rem / sortedCoins(i))

        rem = currRum
        
        println(rem, currRum, numCoins)

        if (rem == 0) return numCoins
      }
    }

    if (rem == 0) numCoins else -1
  }

  val inputCoins = Array(2, 4, 1)

  val inputAmount = 11

  val res = coinChange(inputCoins, inputAmount)

  println(res)
}
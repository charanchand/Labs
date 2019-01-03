package codility

object FrogJump extends App {
  
    def solution(x: Int, y: Int, d: Int): Int = {
    // write your code in Scala 2.12
      
      Math.ceil((y - x) / d).toInt
  }
  
}
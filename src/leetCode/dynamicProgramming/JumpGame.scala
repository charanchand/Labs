package leetCode.dynamicProgramming

object JumpGame extends App {
  
  object Solution {
    def canJump(nums: Array[Int]): Boolean = {
        def check(arr: Array[Int], i: Int, farest: Int): Boolean = arr match {
            case arr if arr.isEmpty || arr.length == 1 => true
            case arr if farest >= arr.length-1 => true
            case arr if i == farest && arr(i) == 0 => false
            case arr => check(arr, i+1, Math.max(farest, arr(i)+i))
        }
        check(nums, 0, nums(0))
    }
}
}
package leetCode

object INcreasingTripletSeq extends App {

  def increasingTriplet(nums: Array[Int]): Boolean = {

    val arrLength = nums.length

    var firstMaxElem = Int.MaxValue
    var secMaxElem = Int.MaxValue

    for (i <- 0 to arrLength - 1) {

      var ci = nums(i)
      println(i, firstMaxElem, secMaxElem)

      if (firstMaxElem >= ci) { firstMaxElem = ci; }

      else if (secMaxElem >= ci) { secMaxElem = ci; }

      else { println(i); return true }
    }
    false
  }

  /*public boolean increasingTriplet(int[] nums) {
	int x = Integer.MAX_VALUE;
	int y = Integer.MAX_VALUE;

	for (int i = 0; i < nums.length; i++) {
		int z = nums[i];

		if (x >= z) {
			x = z;// update x to be a smaller value
		} else if (y >= z) {
			y = z; // update y to be a smaller value
		} else {
			return true;
		}
	}

	return false;
}*/
  val nums = Array(1, 2, 1, 0, 0)

  println(increasingTriplet(nums))
}
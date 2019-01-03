package leetCode

object MergeIntervals extends App {

  class Interval(var _start: Int = 0, var _end: Int = 0) {
    var start: Int = _start
    var end: Int = _end
  }

  def merge(intervals: List[Interval]) //: List[Interval] 
  = {
      val sortedIntervals = intervals.sortWith{ _.start < _.start }
      import scala.collection.mutable.ListBuffer
      val result = ListBuffer[Interval]()
     
      for(i <- sortedIntervals){
        
        
        
      }    
  }
}

/*  def merge(intervals: List[Interval]): List[Interval] = {
    val sortedList = intervals.sortWith { _.start < _.start }
    import scala.collection.mutable.ListBuffer
    val res = ListBuffer[Interval]()

    for (i <- sortedList) {
      if (res.nonEmpty && i.start <= res.last.end)
        res.last.end = math.max(i.end, res.last.end)
      else
        res += i
    }
    res.toList
  }*/
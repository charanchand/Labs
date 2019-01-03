package leetCode.pinterest
import scala.collection.mutable.HashMap

object DomainsCount extends App {

  def subdomainVisits(cpdomains: Array[String]): List[String] = {
    val domainNcount = new HashMap[String, Int]()

    cpdomains.map { d =>
      val ds = d.split(" ")
      val (visits, dm) = (ds(0).toInt, ds(1))
      
      dm.split("\\.").map { w =>
        domainNcount += domainNcount.get(w).map { x => w -> (x + visits) }.getOrElse(w -> visits)
      }
    }
    domainNcount.map { x => x._2 + " " + x._1 }.toList
  }

  val input = Array("900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org")

  subdomainVisits(input).foreach(println)

}
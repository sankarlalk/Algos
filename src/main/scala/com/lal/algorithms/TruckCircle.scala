package com.lal.algorithms

object TruckCircle {
  val MAXINT = 999999
  def findPosition(inp: List[(Int, Int)]): Int = {
    var totalFuel = 0
    var currFuel = 0
    var position = 0
    var amount = 0

    inp.zipWithIndex.foreach( x => x match {
      case(((fuel, dist),pos)) => {
        currFuel = currFuel + fuel - dist
        totalFuel = totalFuel + currFuel

        if (amount + currFuel < 0) {
          amount = 0
          position = position + ((pos + 1) % inp.length)
        }
      }
    })
    if (totalFuel >= 0) position else -1
  }

  def main(args: Array[String]): Unit = {
    println(findPosition(List[(Int,Int)]((4,6), (4,5), (7,3), (4,5))))

  }


}

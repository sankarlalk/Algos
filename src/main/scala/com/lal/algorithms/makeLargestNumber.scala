package com.lal.algorithms

object makeLargestNumber {

  def createLargestNumber(inp: Array[Int]): String = {

    inp.sortWith((x,y) => if(x.toString > y.toString) true else false ).mkString
  }

  def main(args: Array[String]) = {
    println(createLargestNumber(Array(2, 9, 80, 125, 855, 700)))
  }

}

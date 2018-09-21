package com.lal.algorithms.dp

import scala.collection.mutable.ArrayBuffer
import scala.math.max

object knapsack {

  def bottomUp(value: Array[Int], weight: Array[Int], W:Int ): Int = {
    var k = ArrayBuffer.fill(value.length+1, W+1)(0)

    for (i <- (0 to value.length)) {
      for (j <-(0 to W)) {
        if (i ==0 || j ==0 ) {
          k(i)(j) = 0
          //println("Initialization : k[" + i + "][" + j + "] = " + k(i)(j) )
        }
        else {
          if(j - weight(i-1) >= 0){
            val maxvalue = max( k(i-1)(j), value(i-1) + k(i-1)(j-weight(i-1)))
            //println("maxvalue = " + maxvalue)
            k(i)(j) = maxvalue
            //println("if part : k[" + i + "][" + j + "] = " + k(i)(j) )
          }
          else {
            //println("else part = ")
            k(i)(j) = k(i-1)(j)
            //println("else part : k[" + i + "][" + j + "] = " + k(i)(j) )
          }
        }
      }
    }



    k(value.length)(W)
  }
  def main(args: Array[String]) = {

    val value = Array(22, 20, 15, 30, 24, 54, 21, 32, 18, 25)
    val weight = Array(4, 2, 3, 5, 5, 6, 9, 7, 8, 10)
    val totalWeigh = 30
    println("Final output == " + bottomUp(value, weight, totalWeigh))

    val value1 = Array(1, 4, 5, 7)
    val weight1 = Array(1, 3, 4, 5)
    val totalWeigh1 = 7
    println("Final output == " + bottomUp(value1, weight1, totalWeigh1))


  }

}

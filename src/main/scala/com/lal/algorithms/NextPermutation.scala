package com.lal.algorithms

import scala.collection.mutable.ArrayBuffer
import scala.util.control.Breaks

object NextPermutation {
  def nextString(inp: String): String = {
    var output: ArrayBuffer[Char] = new ArrayBuffer[Char](inp.length)
    inp.toCharArray.foreach(x => output.+=(x))
    val loop = new Breaks;
    loop.breakable {
      var minPos: Int = output.length-1
      for (i <- (1 to output.length - 1).reverse) {
        if (output(minPos) > output(i - 1)) {
          val temp = output(minPos)
          output(minPos) = output(i - 1)
          output(i - 1) = temp
          val finalArray = output.take(i) ++ output.takeRight(output.length-i).sortWith(_<_)
          output = finalArray
          loop.break
        }
        else if (output(minPos) < output(i - 1)) {
          minPos = i
        }
      }
    }
    output.mkString
  }

  def main(args: Array[String]): Unit = {
    println(nextString("acbd"))
    println(nextString("acbb"))

  }

}

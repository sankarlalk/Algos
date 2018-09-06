package com.lal.algorithms

import scala.collection.mutable.ArrayBuffer

object MatrixIsland {

  def countIsland(rowSize: Int, colSize: Int, inp: scala.collection.mutable.ArrayBuffer[ArrayBuffer[Int]]) = {
    var totalIslands = 0
    inp.zipWithIndex.foreach( x => x match {
      case(colArray, rowIndex) => {
        colArray.zipWithIndex.foreach(y => y match {
          case(colCell, colIndex) => {
            println("rowIndex = " + rowIndex + " | colIndex = " + colIndex + " | cellValue = " + inp(rowIndex)(colIndex))
            if (inp(rowIndex)(colIndex) == 1) {
              totalIslands = totalIslands + 1
              visitNodes(rowIndex, colIndex, inp)
            }
          }
        })
      }
    })

    totalIslands
  }

  def visitNodes(row: Int, col: Int, inp: ArrayBuffer[ArrayBuffer[Int]]): Unit = {
/*
    inp.foreach(x => {
      x.foreach(y => print(y + " "))
      println()
    })
*/

    if ( inp(row)(col) == 0 || inp(row)(col) == -1) return
    inp(row)(col) = -1

    if( col < inp.length-1) visitNodes(row, col+1, inp)
    if( row < inp.length-1) visitNodes(row +1, col, inp)
    if( col > 0) visitNodes(row, col-1, inp)
    if( row > 0) visitNodes(row-1, col, inp)
  }

  def main(args: Array[String]) = {
    val inputMatrix: ArrayBuffer[ArrayBuffer[Int]] = ArrayBuffer(
      ArrayBuffer(0, 1, 0, 1, 0),
      ArrayBuffer(0, 0, 1, 1, 1),
      ArrayBuffer(1, 0, 0, 0, 0),
      ArrayBuffer(0, 1, 1, 0, 0),
      ArrayBuffer(1, 0, 1, 0, 1)
    )

    //println("Total Island in the Matrix = " + countIsland(5, 5, inputMatrix))

    inputMatrix.foreach(x => {
      x.foreach(y => print(y + " "))
      println()
    })


  }

}

package com.lal.tree

object MaxSumBetweenTwoLeaf {

  case class Node(var data: Int, var left: Node=null, var right: Node=null) {
  }

  def findMaxSum(root: Node, sum: Int): Int = {
    var varSum = sum
    if (root == null) return 0
    if (root.left == null && root.right == null) return root.data
    var ls =  findMaxSum(root.left, varSum)
    var rs = findMaxSum(root.right, varSum)

    if (root.left != null && root.right != null) {
      varSum = varSum.max(ls + rs + root.data)
      return ls.max(rs) + root.data
    }
    if( root.left == null) return rs + root.data
    else return ls + root.data
  }

  def main(args: Array[String]): Unit = {
    val node1: Node = Node(3, null, null)
    val node2: Node = Node(5, null, null)
    val node3 = Node(8, node1, node2)
    val node4 = Node(2, null, null)
    val rootNode = Node(10, node3, node4)

    println(findMaxSum(rootNode, 0))

  }
}

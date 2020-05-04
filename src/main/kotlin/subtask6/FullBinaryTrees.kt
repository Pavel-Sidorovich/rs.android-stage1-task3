package subtask6

import java.util.*

class FullBinaryTrees {

    private val str = StringBuffer()
    private var queue = LinkedList<TreeNode?>()
    private var memo: MutableMap<Int?, List<TreeNode?>?> = HashMap<Int?, List<TreeNode?>?>()
    private var countN = 0

    fun stringForNodeCount(count: Int): String {
        val list = allPossibleFBT(count)
        str.append("[")
        for (b in 0 until list.size - 1) {
            str.append("[")
            countN = 0
            printTree(list[b], count)
            str.append("],")
        }
        if (list.isNotEmpty()) {
            countN = 0
            str.append("[")
            printTree(list[list.size - 1], count)
            str.append("]")
        }

        str.append("]")
        return str.toString()
    }

    private class TreeNode(var `val`: Int) {
        var left: TreeNode? = null
        var right: TreeNode? = null
    }

    private fun printTree(tree: TreeNode?, N: Int) {
        val i = tree?.`val`
        if (i == 0) {
            countN ++
        }
        if (countN != N) {
            str.append("$i").append(",")
            if (tree != null) {
                queue.add(tree.left)
                queue.add(tree.right)
            }
            if (queue.isNotEmpty()) {
                printTree(queue.poll(), N)
            }
        } else {
            str.append("$i")
            queue.clear()
        }
    }

    private fun allPossibleFBT(N: Int): List<TreeNode?> {
        if (!memo.containsKey(N)) {
            val ans: MutableList<TreeNode?> = LinkedList<TreeNode?>()
            if (N == 1) {
                ans.add(TreeNode(0))
            } else if (N % 2 == 1) {
                for (x in 0 until N) {
                    val y = N - 1 - x
                    for (left in allPossibleFBT(x)) {
                        for (right in allPossibleFBT(y)) {
                            val bns = TreeNode(0)
                            bns.left = left
                            bns.right = right
                            ans.add(bns)
                        }
                    }
                }
            }
            memo[N] = ans
        }
        return memo[N] ?: arrayListOf()
    }
}

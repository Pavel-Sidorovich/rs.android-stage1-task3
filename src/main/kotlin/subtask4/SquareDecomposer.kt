package subtask4

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.MutableList
import kotlin.collections.set

class SquareDecomposer {
    val map = HashMap<Int, Long>()

    // TODO: Complete the following function
    fun decomposeNumber(number: Int): Array<Int>? {
        if (number < 0) {
            return null
        }
        var i = 0
        do {
            val square = i * i.toLong()
            map[i] = square
            i++
        } while (i <= number)

        return decomposer(number, map[number] ?: 0L)?.dropLast(1)?.toTypedArray()
    }

    private fun decomposer(n: Int, remain: Long): MutableList<Int>? {
        // basic case
        if (remain == 0L) {
            val r: MutableList<Int> = ArrayList()
            r.add(n)
            return r
        }

        // iterate all element less than n
        for (i in n - 1 downTo 1) {
            if (remain - (map[i] ?: 0L) >= 0) {
                val r = decomposer(i, remain - (map[i] ?: 0L))

                // only get the answer
                if (r != null) {
                    r.add(n)
                    return r
                }
            }
        }

        // no answer
        return null
    }

}

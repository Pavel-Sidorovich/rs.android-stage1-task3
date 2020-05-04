package subtask4

import java.util.*
import kotlin.collections.HashMap
import kotlin.collections.MutableList
import kotlin.collections.set
import kotlin.math.sqrt

fun main() {
    SquareDecomposer().decomposeNumber(7654321)?.forEach {
        print("$it ")
    }
}

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
        } while (i <= sqrt(number.toDouble()))

        return decomposer(number, number * number.toLong())?.dropLast(1)?.toTypedArray()
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
            if (remain - (map[i] ?: i * i.toLong()) >= 0) {
                val r = decomposer(i, remain - (map[i] ?: i * i.toLong()))

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

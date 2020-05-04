package subtask5

import java.util.stream.Collectors

fun main() {
    TelephoneFinder().findAllNumbersFromGivenNumber("8675309")?.forEach {
        println(it)
    }
}

class TelephoneFinder {

    // TODO: Complete the following function
    fun findAllNumbersFromGivenNumber(number: String): Array<String>? {
        if (number.startsWith("-")) {
            return null
        }
        val num = number.toCharArray().map { it - '0'}.toMutableList()
        val list = arrayListOf<String>()
        for ((i, n) in num.withIndex()) {
            val arr = when (n) {
                0 -> arrayOf(0, 8)
                1 -> arrayOf(1, 2, 4)
                2 -> arrayOf(2, 1, 3, 5)
                3 -> arrayOf(3, 2, 6)
                4 -> arrayOf(4, 1, 5, 7)
                5 -> arrayOf(5, 2, 4, 6, 8)
                6 -> arrayOf(6, 3, 5, 9)
                7 -> arrayOf(7, 4, 8)
                8 -> arrayOf(8, 0, 5, 7, 9)
                else -> arrayOf(9, 6, 8)
            }
            var size = arr.size - 1
            while (size != 0) {
                num[i] = arr[size]
                val str = num.stream().map { it.toString() }.collect(Collectors.joining())
                list.add(str)
                size --
            }
            num[i] = arr[0]
        }
        return list.toList().toTypedArray()
    }
}

package subtask3

import java.lang.Integer.max

fun main() {
    print(ArrayCalculator().maxProductOf(3, arrayOf(-1, "2", "3", 4)))
}

class ArrayCalculator {

    // TODO: Complete the following function
    fun maxProductOf(numberOfItems: Int, itemsFromArray: Array<Any>): Int {
        var number = numberOfItems
        var result = 1
        var end = 0
        val list = itemsFromArray.filterIsInstance<Int>().toMutableList()
        var size = list.size - 1
        if (size <= numberOfItems) {
            if (list.isEmpty()) {
                return 0
            }
            return list.reduce { acc, i -> acc * i }
        }
        list.sort()
        while (number >= 2) {
            val en = list[end] * list[end + 1]
            val st = list[size] * list[size - 1]
            if (en > st) {
                result *= en
                end += 2
            } else {
                result *= st
                size -= 2
            }
            number -= 2
        }
        if (number == 1) {
            result *= max(list[end], list[size])
        }

        return result
    }
}

package subtask1

import java.lang.Math.abs


fun main() {
    print(PolynomialConverter().convertToStringFrom(arrayOf(4)))
}

class PolynomialConverter {

    fun convertToStringFrom(numbers: Array<Int>): String? {
        if (numbers.isEmpty()) {
            return null
        }
        val str = StringBuilder()
        var length = 0
        var size = numbers.size - 1
        while (size > -1) {
            when (numbers[length]) {
                0 -> str.append("")
                1 -> str.append("${if(length == 0) "" else " + "}${if (size > 0) "x" else ""}${if (size > 1) "^${size}" else ""}")
                -1 -> str.append("${if(length == 0) "" else " - "}${if (size > 0) "x" else ""}${if (size > 1) "^${size}" else ""}")
                in Int.MIN_VALUE..0 -> str.append("${if(length == 0) "" else " - "}${kotlin.math.abs(numbers[length])}${if (size > 0) "x" else ""}${if (size > 1) "^${size}" else ""}")
                else -> str.append("${if(length == 0) "" else " + "}${numbers[length]}${if (size > 0) "x" else ""}${if (size > 1) "^${size}" else ""}")
            }
            size --
            length ++
        }
        return str.toString()
    }
}

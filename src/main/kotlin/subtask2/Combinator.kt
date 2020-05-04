package subtask2

fun main() {
    print(Combinator().checkChooseFromArray(arrayOf(184756, 20)))
}

class Combinator {

    // TODO: Complete the following function
    var map = HashMap<Int, Long>()
    fun checkChooseFromArray(array: Array<Int>): Int? {
        val n = array[1]
        val c = array[0].toLong()
        var i = 1
        var temp = 1L
        var z = 1

        while (i <= n) {
            temp *= i
            map[i] = temp
            i ++
        }

        while (z != n) {
            val k = map[n]!! / (map[n - z]!! * map[z]!!)
            if (k == c) {
                return z
            }
            z ++
        }
        return null
    }


}

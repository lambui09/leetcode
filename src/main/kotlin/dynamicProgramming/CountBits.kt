package dynamicProgramming

import java.lang.StringBuilder

object CountBits {

    //create binary
    fun toBinary(n: Int): ArrayList<Int> {
        val result = arrayListOf<Int>()
        var decimal = 0
        var weight = 1
        var number = n
        while (number != 0) {
            val rem = number % 10
            decimal += rem * weight
            number /= 10
            weight *= 2
            result.add(rem)
        }
        return result
    }
}
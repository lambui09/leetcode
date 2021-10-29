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
            number /= 2
            weight *= 2
            result.add(number)
        }
        println("${result}")
        return result
    }

    fun binary(n: Int): Int {
        var result = 0
        var temp = n
        var binaryNumber : Int = 0
        var remainder : Int
        var i = 1
        var step = 0
        while (temp != 0) {
            //3%2c= 1
            //step 2 temp= 1 %2= 1
            remainder = temp % 2
            //3/2 = 1
            //step 2 temp = 1/2 = 0
            temp /= 2
            //binary = 1*1 + 0
            binaryNumber += (remainder * i)
            //i*10
            i *= 10
            println("${remainder}")
            println("Step ${ step++}, Remainder = ${remainder}, Quotient =${n / 2}")
            result += remainder
        }
        return result
    }

    fun countBits(n: Int): IntArray {
        var intArray = mutableListOf<Int>()
        for (i in 0 until  n) {
            println("${i}--${binary(i)}")
            intArray.add(i, binary(i))
        }
        return intArray.toIntArray()
    }

}
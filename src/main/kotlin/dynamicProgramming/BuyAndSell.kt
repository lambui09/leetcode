package dynamicProgramming

import kotlin.math.abs

object BuyAndSell {
    //intArrayOf(1,2,4,2,5,7,2,4,9,0,9)
    //7,6,4,3,1
    fun maxProfit(prices: IntArray): Int {
        var left = 0
        var right = 1
        var maxValue = 0
        do {
            println("right ------ ${prices[right]}")
            //isssue laf left default
            if (prices[left] < prices[right]) {
                maxValue = maxOf(prices[right] - prices[left], maxValue)
            } else {
              left = right
            }
            right++
        } while (right < prices.size)
        return maxValue
    }

    fun checkOddAndEven(n: Int): Boolean {
        if (n % 2 == 0) {
            return true
        }
        return false
    }
}
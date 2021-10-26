package dynamicProgramming

object BuyAndSell {
    fun maxProfit(prices: IntArray): Int {
        var left = 0
        var right = 1
        var maxValue = 0
        while (right < prices.size) {
            if (prices[left] < prices[right]) {
                println("right : ${prices[right]} :left : ${prices[left]}---${prices[right] - prices[left]}")
                maxValue = maxOf(prices[right] - prices[left], maxValue)
            } else {
                left++
            }
            right++
        }
        return maxValue
    }

    fun checkOddAndEven(n: Int): Boolean {
        if (n % 2 == 0) {
            return true
        }
        return false
    }
}
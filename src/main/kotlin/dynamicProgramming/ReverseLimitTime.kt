package dynamicProgramming

object ReverseLimitTime {
    fun reverseLimitTime(s: Int): Int {
        var result = 0
        var unSignX = Math.abs(s)
        while (unSignX > 0) {
            var lastNumber = unSignX % 10
            unSignX /= 10
            result = result * 10 + lastNumber
            if (s > Int.MAX_VALUE) {
                return 0
            }
        }
        if (s < 0) {
            return - result
        }
        return result
    }
}
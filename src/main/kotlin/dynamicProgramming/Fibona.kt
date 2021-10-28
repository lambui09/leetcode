package dynamicProgramming

object Fibona {
    fun fibo1(n: Int): Int {
        if (n < 2) return n
        if (n == 2) return 1
        return fibo1(n - 1) + fibo1(n - 2)
    }

    val cachec = mutableMapOf<Int, Int>()
    fun fibo2(n2: Int): Int {
        val cached = cachec[n2]
        if (cached != null) return cached

        if (n2 < 2) return n2
        val result = fibo2(n2 - 1) + fibo2(n2 - 2)
        cachec[n2] = result
        println("${result}")
        return result
    }

    //khu de quy
    var fmax = arrayOf(1000)
    fun fiboBest(n: Int): Int {
        if (fmax[n] != -1) {
            return fmax[n]
        }
        if (n == 0 || n == 1) {
            return 1.also { fmax[n] = it }
        }
        fmax[n] = fmax[n - 1] + fmax[n - 2]
        return fmax[n]

    }
}
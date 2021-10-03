package dynamicProgramming

object ClimeStair {
    //timeout -> use for to de-recursion
    fun climStair(number: Int): Int {
        if (number == 1) return number
        if (number == 2) return number
        return  climStair(number-1) + climStair(number -2)
    }

    fun climStairBest(number: Int): Int {
        if (number == 1) return number
        if (number == 2) return number
        var x = 1
        var y = 2
        //i ..3 in number: number. until number -1
        for (i in 3 until number){
            var temp = y
            y += x
            x = temp
        }
        return x + y
    }
}
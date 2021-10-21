package dynamicProgramming

object PascalTrigle {
    /**
     * array = arraytemp: 1.[1] ->
     * 2.[[1],[1,1]]
     * 3.[[1],[1,1], [1,2,1]]
     * 4.[[1],[1,1], [1,2,1], [1,3,3,1]]
     */
    fun generate(numRow: Int): List<List<Int>> {
        var list: ArrayList<ArrayList<Int>> = ArrayList()
        if (numRow == 0) {
            list.add(arrayListOf(1))
            return list
        }
        val row: ArrayList<Int> = arrayListOf()
        for (i in 0..numRow) {
            println("i=${i}")
            row.add(0, 1)
            for (j in 0 until i) {
                println("j=${j}")
                row.set(j, row.get(j) + row.get(j + 1))
                println("row ${row}")
            }
            row.set(0, 1)
            list.add(i,row)
            println("list ---${list}")
        }
        println("result :${list}")
        return list
    }

    fun pascalTrigleAtposition(numRow: Int): List<Int> {
        val row: ArrayList<Int> = arrayListOf()
        if (numRow == 0) return arrayListOf(1)
        if (numRow == 1) return arrayListOf(1, 1)
        for (i in 0..numRow) {
            println("i=${i}")
            row.add(0, 1)
            for (j in 0 until i) {
                println("j=${j}")
                row.set(j, row.get(j) + row.get(j + 1))
                println("row ${row}")
            }
            row.set(0, 1)
        }
        println("result :${row}")
        return row
    }
}
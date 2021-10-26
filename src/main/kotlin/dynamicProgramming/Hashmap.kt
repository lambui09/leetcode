package dynamicProgramming

object Hashmap {
    val weights = hashMapOf("Foo" to 68, "Bar" to 30, "Baz" to 10)

    //Ascending order
    val sortedWeightAsc = weights.toList().sortedBy { (key, value) ->
        value
    }
    val sortedWeightsDesc = weights.toList().sortedByDescending { (key, value) ->
        value
    }
}
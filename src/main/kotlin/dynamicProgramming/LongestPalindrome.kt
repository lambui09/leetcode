package dynamicProgramming

object LongestPalindrome {
    fun longestPalindrome(s: String): String {
        val listPalidromes = mutableSetOf<String>()
        s.forEachIndexed { index, item ->
            for (j in index + 1..s.length) {
                if (isPalindrome(s.substring(index, j))) {
                    listPalidromes.add(s.substring(index, j))
                }
            }
        }
        println(maxLength(listPalidromes))
        return maxLength(listPalidromes)
    }

    fun isPalindrome(s: String): Boolean {
        val stringbuilder = StringBuilder(s)
        val reverse = stringbuilder.reverse().toString()
        return s == reverse
    }

    fun maxLength(listStrings: MutableSet<String>): String {
        var lengthMax = 0
        listStrings.forEachIndexed { index, s ->
            if (lengthMax < s.length) {
                lengthMax = s.length
            }
        }
        listStrings.forEachIndexed { index, s ->
            if (s.length == lengthMax) {
                return s
            }
        }
        return listStrings.elementAt(0)
    }
}
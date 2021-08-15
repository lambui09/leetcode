package dynamicProgramming

import kotlin.math.max

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

    //
    fun isOdd(str: String): Boolean {
        return str.length % 2 == 0 || str.isEmpty() || str.length == 1
    }

    fun longestPalindrome2(str: String): String {
        var lengthStrTemp = 0
        var strTemp = ""
        var half = str.length / 2
        //odd
        var left: Int
        var right: Int
        // odd
        if (isOdd(str)) {
            left = half
            right = half
            while (left >= 0 && right < str.length && str[left] == str[right]) {
                if (right - left + 1 > lengthStrTemp) {
                    strTemp.substring(left, right)
                    lengthStrTemp = right - left + 1
                }
                left--
                right++
            }
            return strTemp
        }
        // even
        left = half
        right = half + 1
        while (left >= 0 && right < str.length && str[left] == str[right]) {
            if (right - left + 1 > lengthStrTemp) {
                strTemp.substring(left, right)
                lengthStrTemp = right - left + 1
            }
            left--
            right++
        }
        return strTemp
    }

    fun longestPalindrome3(s: String): String {
        for (index in s.length - 1 downTo 2) {
            for (startIndex in s.indices) {
                val temp = s.substring(startIndex, startIndex + index + 1)
                println(temp)
                if (isPalindrome(temp)) {
                    return temp
                }
            }
        }
        return ""
    }

    fun longestPalindromeDynamic(str: String): String {
        var left = 0
        var right = 0
        if (str.isEmpty() || str.length == 1) {
            return str
        }
        str.forEachIndexed { index, c ->
            val odd = checkExpand(str, index, index)
            val even = checkExpand(str, index, index + 1)
            val size = max(odd, even)
            if (right - left < size) {
                left = index - (size - 1) / 2
                right = index + (size) / 2
            }
        }
        return str.substring(left, right + 1)
    }

     fun checkExpand(str: String, lf: Int, rt: Int): Int {
        var left = lf
        var right = rt
        if (left > right) return 0
        while (left >= 0 && right < str.length && str[left] == str[right]) {
            left--
            right++
        }
        return right - left - 1
    }
}
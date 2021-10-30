package dynamicProgramming

object IsSubsequence {
    //s = "abc", t = "ahbgdc" s= childString, t= super
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.equals("")) {
            return true
        }
        var index: Int = 0
        for (i in t.indices) {
            if (t.get(i) == s.get(index)) {
                index++
            }
            if (index >= s.length) {
                return true
            }
        }
        return false
    }
}
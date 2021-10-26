import dynamicProgramming.BuyAndSell.maxProfit
import dynamicProgramming.Fibona.fibo1
import dynamicProgramming.Fibona.fibo2
import dynamicProgramming.LongestPalindrome.longestPalindrome
import dynamicProgramming.LongestPalindrome.longestPalindrome2
import dynamicProgramming.LongestPalindrome.longestPalindrome3
import dynamicProgramming.LongestPalindrome.longestPalindromeDynamic
import dynamicProgramming.Matrix2D.matrix
import dynamicProgramming.MaxArray
import dynamicProgramming.MaxArray.maxSubArray
import dynamicProgramming.PascalTrigle.generate
import dynamicProgramming.PascalTrigle.pascalTrigleAtposition

fun main(args: Array<String>) {
    val nums = intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)
//    val nums2 = intArrayOf(5, 4, -1, 7, 8)
    val nums2 = intArrayOf(7,1,5,3,6,4)
    val nums3 = intArrayOf(1,2,4,2,5,7,2,4,9,0,9)

//    println(longestPalindrome("babad"))
//    println(longestPalindromeDynamic("civilwartestingwhetherthatnaptionoranynartionsoconceivedandsodedicatedcanlongendureWeareqmetonagreatbattlefiemldoftzhatwarWehavecometodedicpateaportionofthatfieldasafinalrestingplaceforthosewhoheregavetheirlivesthatthatnationmightliveItisaltogetherfangandproperthatweshoulddothisButinalargersensewecannotdedicatewecannotconsecratewecannothallowthisgroundThebravelmenlivinganddeadwhostruggledherehaveconsecrateditfaraboveourpoorponwertoaddordetractTgheworldadswfilllittlenotlenorlongrememberwhatwesayherebutitcanneverforgetwhattheydidhereItisforusthelivingrathertobededicatedheretotheulnfinishedworkwhichtheywhofoughtherehavethusfarsonoblyadvancedItisratherforustobeherededicatedtothegreattdafskremainingbeforeusthatfromthesehonoreddeadwetakeincreaseddevotiontothatcauseforwhichtheygavethelastpfullmeasureofdevotionthatweherehighlyresolvethatthesedeadshallnothavediedinvainthatthisnationunsderGodshallhaveanewbirthoffreedomandthatgovernmentofthepeoplebythepeopleforthepeopleshallnotperishfromtheearth"))
//    println(MaxArray.maxSubArray(nums2))

//    fibo2(25)
    //    println("${pascalTrigleAtposition(3)}")
//    generate(2)
//    matrix()
    println("${maxProfit(nums3)}")


}

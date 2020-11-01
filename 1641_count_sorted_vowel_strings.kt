/*
 * 1641. Count Sorted Vowel Strings
 *
 * Q: https://leetcode.com/problems/count-sorted-vowel-strings/
 * A: https://leetcode.com/problems/count-sorted-vowel-strings/discuss/919428/Kt-Js-Py3-Cpp-1-Liners
 */

class Solution {
    fun countVowelStrings(N: Int, last: Char = '0'): Int {
        if (N == 0)
            return 1
        var total = 0
        "aeiou".forEach { c ->
            if (last <= c)
                total += countVowelStrings(N - 1, c)
        }
        return total
    }
}

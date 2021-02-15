/*
 * 1758. Minimum Changes To Make Alternating Binary String
 *
 * Q: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/
 * A: https://leetcode.com/problems/minimum-changes-to-make-alternating-binary-string/discuss/1064549/Kt-Js-Py3-Cpp-Explore-2-Candidates
 */

class Solution {
    fun minOperations(s: String): Int {
        var a = 0
        var b = 1
        var first = 0
        var second = 0
        for (c in s) {
            if (a == Character.getNumericValue(c)) ++first
            if (b == Character.getNumericValue(c)) ++second
            a = a xor 1
            b = b xor 1
        }
        return Math.min(first, second)
    }
}

/*
 * 1653. Minimum Deletions to Make String Balanced
 *
 * Q: https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/
 * A: https://leetcode.com/problems/minimum-deletions-to-make-string-balanced/discuss/938408/Kt-Js-Py3-Cpp-Prefix-%2B-Suffix
 */

class Solution {
    fun minimumDeletions(s: String): Int {
        var N = s.length
        var prefix = IntArray(N) { 0 }
        var suffix = IntArray(N) { 0 }
        var beg = 0
        var end = N - 1
        for (i in beg..end)     prefix[i] = (if (s[i] == 'b') 1 else 0) + (if (beg < i) prefix[i - 1] else 0)
        for (i in end downTo 0) suffix[i] = (if (s[i] == 'a') 1 else 0) + (if (i < end) suffix[i + 1] else 0)
        return prefix.zip(suffix){ a, b -> a + b }.min()!!.minus(1)  // ⭐️ -1 since we only need to delete 'a' xor 'b' at the optimal "pivot" index
    }
}

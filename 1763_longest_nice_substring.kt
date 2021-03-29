/*
 * 1763. Longest Nice Substring
 *
 * Q: https://leetcode.com/problems/longest-nice-substring/
 * A: https://leetcode.com/problems/longest-nice-substring/discuss/1074560/Kt-Js-Py3-Cpp-Recursive
 */

class Solution {
    fun longestNiceSubstring(s: String): String {
        var best = ""
        fun go(s: String) {
            var seen = s.toSet()
            var isNice = { c: Char -> seen.contains(c.toLowerCase()) && seen.contains(c.toUpperCase()) }
            for (i in 0 until s.length) {
                if (!isNice(s[i])) {
                    go(s.substring(0, i)); go(s.substring(i + 1))
                    return
                }
            }
            if (best.length < s.length)
                best = s
        }
        go(s)
        return best
    }
}

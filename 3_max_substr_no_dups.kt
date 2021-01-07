/*
 * 3. Longest Substring Without Repeating Characters
 *
 * Q: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 * A: https://leetcode.com/problems/longest-substring-without-repeating-characters/discuss/504179/Kt-Js-Py3-Cpp-Best-i-Last-Seen-Duplicate-Index
 */

class Solution {
    fun lengthOfLongestSubstring(s: String): Int {
        var best = 0
        var last = -1
        var m = mutableMapOf<Char, Int>()
        s.forEachIndexed { i, c ->
            last = Math.max(last, m.getOrDefault(c, -1)); m[c] = i
            best = Math.max(best, i - last)
        }
        return best
    }
}

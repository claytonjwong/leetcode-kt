/*
 * 395. Longest Substring with At Least K Repeating Characters
 *
 * Q: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/
 * A: https://leetcode.com/problems/longest-substring-with-at-least-k-repeating-characters/discuss/949961/Kt-Js-Py3-Cpp-Recursively-Reduce-Search-Space-i..j
 */

class Solution {
    fun longestSubstring(s: String, T: Int, i: Int = 0, j_: Int = 1e4.toInt()): Int {
        var best = 0
        var m = mutableMapOf<Char, Int>()
        var j = Math.min(j_, s.length)
        for (k in i until j)
            m[s[k]] = if (m.contains(s[k])) m[s[k]]!!.plus(1) else 1
        var need = mutableSetOf<Char>()
        for (k in i until j)
            if (m[s[k]]!! < T)
                need.add(s[k])
        if (need.size == 0)                   // 🎯 valid substring [i..j)
            return j - i
        var next = mutableListOf<Int>(i - 1)  // ⭐️ i - 1 since next indexes are non-inclusive, but i is inclusive
        for (k in i until j)
            if (need.contains(s[k]))
                next.add(k)
        next.add(j)
        for (k in 1 until next.size)          // 🚀 recursively search for valid substrings in between next indexes (previous + 1 because next indexes are non-inclusive)
            best = Math.max(best, longestSubstring(s, T, next[k - 1] + 1, next[k]))
        return best
    }
}

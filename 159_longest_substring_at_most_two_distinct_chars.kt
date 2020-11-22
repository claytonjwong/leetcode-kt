/*
 * 159. Longest Substring with At Most Two Distinct Characters
 *
 * Q: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/
 * A: https://leetcode.com/problems/longest-substring-with-at-most-two-distinct-characters/discuss/854873/Kt-Js-Py3-Cpp-Sliding-Window-%2B-Map
 */

class Solution {
    fun lengthOfLongestSubstringTwoDistinct(s: String): Int {
        var m = mutableMapOf<Char, Int>()
        var best = 0
        var N = s.length
        var i = 0
        var j = 0
        while (j < N) {
            m[s[j]] = if (m.contains(s[j])) m[s[j]]!!.plus(1) else 1; ++j  // ✅ expand window with s[j]
            while (2 < m.size) {                                           // ❌ shrink window with s[i] until there are at most 2 distinct chars
                m[s[i]] = m[s[i]]!!.minus(1)
                if (m[s[i]] == 0)
                    m.remove(s[i])
                ++i
            }
            best = Math.max(best, j - i)                                   // 🎯 longest substring with at most 2 distinct chars
        }
        return best
    }
}

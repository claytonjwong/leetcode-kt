/*
 * 340. Longest Substring with At Most K Distinct Characters
 *
 * Q: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/
 * A: https://leetcode.com/problems/longest-substring-with-at-most-k-distinct-characters/discuss/992358/Kt-Js-Py3-Cpp-Sliding-Window-%2B-Map
 */

class Solution {
    fun lengthOfLongestSubstringKDistinct(s: String, k: Int): Int {
        var best = 0
        var m = mutableMapOf<Char, Int>()
        var i = 0
        var j = 0
        var N = s.length
        while (j < N) {
            m[s[j]] = 1 + m.getOrDefault(s[j], 0); ++j
            while (k < m.size) {                        // ⭐️ maintain invariant
                m[s[i]] = m[s[i]]!! - 1
                if (m[s[i]] == 0)
                    m.remove(s[i])
                ++i
            }
            best = Math.max(best, j - i)                // 🎯 maximum length window
        }
        return best
    }
}

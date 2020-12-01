/*
 * 243. Shortest Word Distance
 *
 * Q: https://leetcode.com/problems/shortest-word-distance/
 * A: https://leetcode.com/problems/shortest-word-distance/discuss/670999/Kt-Js-Py3-Cpp-Last-Seen-K-th-Index
 */

class Solution {
    fun shortestDistance(A: Array<String>, s: String, t: String): Int {
        var best = (1e9 + 7).toInt()
        var i = -1
        var j = -1
        A.forEachIndexed{ k, word ->
            if (word == s) i = k
            if (word == t) j = k
            if (-1 < i && -1 < j)
                best = Math.min(best, Math.abs(i - j))
        }
        return best
    }
}

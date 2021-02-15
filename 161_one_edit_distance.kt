/*
 * 161. One Edit Distance
 *
 * Q: https://leetcode.com/problems/one-edit-distance/
 * A: https://leetcode.com/problems/one-edit-distance/discuss/152967/Kt-Js-Py3-Cpp-Linear-Scan
 */

class Solution {
    fun isOneEditDistance(s: String, t: String): Boolean {
        var M = s.length
        var N = t.length
        var i = 0
        var j = 0
        var k = 0
        while (Math.abs(i - j) <= 1 && !(M <= i && N <= j)) {
            if (i < M && j < N && s[i] == t[j]) {
                ++i
                ++j
            } else {
                ++k
                i = if (N <= M) i + 1 else i
                j = if (M <= N) j + 1 else j
            }
        }
        return k == 1
    }
}

/*
 * 1629. Slowest Key
 *
 * Q: https://leetcode.com/problems/slowest-key/
 * A: https://leetcode.com/problems/slowest-key/discuss/909815/Kt-Js-Py3-Cpp-Best-Time
 */

class Solution {
    fun slowestKey(A: IntArray, keys: String): Char {
        var best = 0
        var ans = '0'
        keys.forEachIndexed { i, key ->
            var time = if (0 < i) A[i] - A[i - 1] else A[i]
            if (best < time || (best == time && ans < key)) {
                best = time
                ans = key
            }
        }
        return ans
    }
}

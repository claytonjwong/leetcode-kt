/*
 * 334. Increasing Triplet Subsequence
 *
 * Q: https://leetcode.com/problems/increasing-triplet-subsequence/
 * A: https://leetcode.com/problems/increasing-triplet-subsequence/discuss/977048/Kt-Js-Py3-Cpp-Construct-a-b-c
 */

class Solution {
    fun increasingTriplet(A: IntArray): Boolean {
        var INF: Long = (6e9).toLong()
        var a: Long = INF
        var b: Long = INF
        var c: Long = INF
        var ok = false
        A.forEach { x ->
            if      (x <= a) a = x.toLong()
            else if (x <= b) b = x.toLong()
            else if (c <= c) c = x.toLong()
        }
        return c < INF
    }
}

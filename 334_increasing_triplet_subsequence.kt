/*
 * 334. Increasing Triplet Subsequence
 *
 * Q: https://leetcode.com/problems/increasing-triplet-subsequence/
 * A: https://leetcode.com/problems/increasing-triplet-subsequence/discuss/977048/Kt-Js-Py3-Cpp-Track-Two-Minimums
 */

class Solution {
    fun increasingTriplet(A: IntArray): Boolean {
        var a: Long = (6e9).toLong()
        var b: Long = (6e9).toLong()
        var ok = false
        A.forEach { x ->
            if (x <= a)
                a = x.toLong()
            else if (x <= b)
                b = x.toLong()
            else
                ok = true
        }
        return ok
    }
}

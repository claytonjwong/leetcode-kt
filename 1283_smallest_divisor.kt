/*
 * 1283. Find the Smallest Divisor Given a Threshold
 *
 * Q: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/
 * A: https://leetcode.com/problems/find-the-smallest-divisor-given-a-threshold/discuss/925931/Kt-Js-Py3-Cpp-Binary-Search
 */

class Solution {
    fun smallestDivisor(A: IntArray, T: Int): Int {
        var f = { div: Int -> A.map{ Math.ceil(it / div.toDouble()) }.sum() }
        var i = 1
        var j = 1e6.toInt()
        while (i < j) {
            var k = (i + j) / 2
            if (T < f(k))
                i = k + 1
            else
                j = k
        }
        return i
    }
}

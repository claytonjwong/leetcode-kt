/*
 * 1010. Pairs of Songs With Total Durations Divisible by 60
 *
 * Q: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/
 * A: https://leetcode.com/problems/pairs-of-songs-with-total-durations-divisible-by-60/discuss/256716/Kt-Js-Py3-Cpp-Map-of-Buckets
 */

class Solution {
    fun numPairsDivisibleBy60(A: IntArray): Int {
        var pairs = 0
        var m = mutableMapOf<Int, Int>()
        A.forEachIndexed{ i, x -> A[i] = x % 60 }
        A.forEach{ x ->
            var y = (60 - x) % 60
            pairs += m.getOrElse(y) { 0 }
            m[x] = 1 + m.getOrPut(x) { 0 }
        }
        return pairs
    }
}

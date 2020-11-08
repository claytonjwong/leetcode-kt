/*
 * 1099. Two Sum Less Than K
 *
 * Q: https://leetcode.com/problems/two-sum-less-than-k/
 * A: https://leetcode.com/problems/two-sum-less-than-k/discuss/603797/Kt-Js-Py3-Cpp-Greedy-%2B-Brute-Force-solutions
 */

// greedy
class Solution {
    fun twoSumLessThanK(A: IntArray, K: Int): Int {
        A.sort()
        var best = -1
        var i = 0
        var j = A.lastIndex
        while (i < j) {
            if (A[i] + A[j] < K) {
                best = Math.max(best, A[i] + A[j])
                ++i
            } else {
                --j
            }
        }
        return best
    }
}

// brute-force
class Solution {
    fun twoSumLessThanK(A: IntArray, K: Int): Int {
        var best = -1
        var N = A.size
        for (i in 0 until N)
            for (j in i + 1 until N)
                if (A[i] + A[j] < K)
                    best = Math.max(best, A[i] + A[j])
        return best
    }
}

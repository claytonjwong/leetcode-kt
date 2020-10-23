/*
 * 456. 132 Pattern
 *
 * Q: https://leetcode.com/problems/132-pattern/
 * A: https://leetcode.com/problems/132-pattern/discuss/907505/Kt-Js-Py3-Cpp-Trivial-solutions
 */

class Solution {
    fun find132pattern(A: IntArray): Boolean {
        var N = A.size
        var first = A[0]
        for (j in 1 until N) {
            first = Math.min(first, A[j])  // ⭐️ minimum A[i] seen so far
            for (k in j + 1 until N)
                if (first < A[k] && A[k] < A[j])
                    return true
        }
        return false
    }
}

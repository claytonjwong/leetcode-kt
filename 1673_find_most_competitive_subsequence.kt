/*
 * 1673. Find the Most Competitive Subsequence
 *
 * Q: https://leetcode.com/problems/find-the-most-competitive-subsequence/
 * A: https://leetcode.com/problems/find-the-most-competitive-subsequence/discuss/952775/Kt-Js-Py3-Cpp-Monotonic-Queue
 */

class Solution {
    fun mostCompetitive(A: IntArray, K: Int): IntArray {
        var S = Stack<Int>()
        var N = A.size
        var i = 0
        while (i < N)
            if (0 < S.size && A[i] < S.peek() && i + K - S.size < N)  // 📈 maintain monotonic queue invariant
                S.pop()
            else
                S.push(A[i++])
        return S.slice(0..K - 1).toIntArray()
    }
}

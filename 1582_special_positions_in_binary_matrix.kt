/*
 * 1582. Special Positions in a Binary Matrix
 *
 * Q: https://leetcode.com/problems/special-positions-in-a-binary-matrix
 * A: https://leetcode.com/problems/special-positions-in-a-binary-matrix/discuss/843916/Kt-Js-Py3-Cpp-Sum-Row-and-Column
 */

class Solution {
    fun numSpecial(A: Array<IntArray>): Int {
        var cnt = 0
        var M = A.size
        var N = A[0].size
        var row = IntArray(M) { 0 }
        var col = IntArray(N) { 0 }
        for (i in 0 until M) {
            for (j in 0 until N) {
                if (A[i][j] == 1) {
                    ++row[i]
                    ++col[j]
                }
            }
        }
        for (i in 0 until M)
            for (j in 0 until N)
                if (A[i][j] == 1 && row[i] == 1 && col[j] == 1)
                    ++cnt
        return cnt
    }
}

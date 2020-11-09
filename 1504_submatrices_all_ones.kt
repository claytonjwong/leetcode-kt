/*
 * 1504. Count Submatrices With All Ones
 *
 * Q: https://leetcode.com/problems/count-submatrices-with-all-ones/
 * A: https://leetcode.com/problems/count-submatrices-with-all-ones/discuss/762330/Kt-Js-Py3-Cpp-Brute-Force
 */

class Solution {
    fun numSubmat(A: Array<IntArray>): Int {
        fun go(row: Int, col: Int): Int {
            var M = A.size
            var N = A[0].size
            var cnt = 0
            for (i in row until M)
                for (j in col until N)
                    if (A[i][j] == 1) {
                       ++cnt
                    } else {
                        N = j
                        break
                    }
            return cnt
        }
        var total = 0
        var M = A.size
        var N = A[0].size
        for (i in 0 until M)
            for (j in 0 until N)
                total += go(i, j) // 🎯 count of all submatrices starting with i,j as top-left corner
        return total
    }
}

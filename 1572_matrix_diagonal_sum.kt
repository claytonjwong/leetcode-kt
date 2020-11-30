/*
 * 1572. Matrix Diagonal Sum
 *
 * Q: https://leetcode.com/problems/matrix-diagonal-sum/
 * A: https://leetcode.com/problems/matrix-diagonal-sum/discuss/830407/Kt-Js-Py3-Cpp-solutions
 */

// 1-liner
class Solution {
    fun diagonalSum(A: Array<IntArray>): Int {
        var N = A.size
        return A.mapIndexed{ i, _ -> A[i][i] + A[i][N - 1 - i] }!!.sum() - (if (N % 2 == 1) A[N / 2][N / 2] else 0)
    }
}

// verbose
class Solution {
    fun diagonalSum(A: Array<IntArray>): Int {
        var N = A.size
        var total = 0
        for (i in 0 until N)
            total += A[i][i] + A[i][N - 1 - i]  // 🎯 accumulate sum of both diagonals simultaneously
        if (A.size % 2 == 1)
            total -= A[N / 2][N / 2]            // ⭐️ subtract middle element once if it was added twice
        return total
    }
}

/*
 * 498. Diagonal Traverse
 *
 * Q: https://leetcode.com/problems/diagonal-traverse/
 * A: https://leetcode.com/problems/diagonal-traverse/discuss/986121/Kt-Js-Py3-Cpp-Traverse-(Up-%2B-Right)
 */

class Solution {
    fun findDiagonalOrder(A: Array<IntArray>): IntArray {
        var rev = 0
        var diags = intArrayOf()
        var M = A.size
        var N = if (0 < M) A[0].size else 0
        fun diag(i_: Int, j_: Int): IntArray {  // traverse diag 👆 👉  (up + right)
            var i = i_
            var j = j_
            var res = mutableListOf<Int>()
            while (0 <= i && j < N)
                res.add(A[i--][j++])
            if (rev == 1)
                res.reverse()
            rev = rev xor 1
            return res.toIntArray()
        }
        for (i in 0 until M)                    // first column
            diags = diags + diag(i, 0)
        for (j in 1 until N)                    // last row
            diags = diags + diag(M - 1, j)
        return diags
    }
}

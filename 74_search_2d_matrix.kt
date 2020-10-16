/*
 * 74. Search a 2D Matrix
 *
 * Q: https://leetcode.com/problems/search-a-2d-matrix/
 * A: https://leetcode.com/problems/search-a-2d-matrix/discuss/605294/Kt-Js-Py3-Cpp-Upper-Bound-(ie.-Binary-Search)
 */

class Solution {
    fun upperBound(A: List<Int>, target: Int): Int {
        val N = A.size
        var i = 0
        var j = N
        while (i < j) {
            val k = (i + j + 1) / 2
            if (k < N && A[k] <= target)
                i = k
            else
                j = k - 1
        }
        return j + 1
    }
    fun searchMatrix(A: Array<IntArray>, T: Int): Boolean {
        if (A.isEmpty() || A[0].isEmpty())
            return false
        var first = A.map { it[0] }
        var row = upperBound(first, T) - 1
        var col = upperBound(A[row].toList(), T) - 1
        return A[row][col] == T
    }
}

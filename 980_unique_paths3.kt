/*
 * 980. Unique Paths III
 *
 * Q: https://leetcode.com/problems/unique-paths-iii/
 * A: https://leetcode.com/problems/unique-paths-iii/discuss/856143/Kt-Js-Py3-Cpp-DFS-%2B-BT
 */

class Solution {
    fun uniquePathsIII(A: Array<IntArray>): Int {
        var total = 0
        var paths = 0
        var M = A.size
        var N = A[0].size
        var s = intArrayOf()
        var t = intArrayOf()
        for (i in 0 until M) {
            for (j in 0 until N) {
                if (A[i][j] == 0) ++total
                if (A[i][j] == 1) s = intArrayOf(i, j)
                if (A[i][j] == 2) t = intArrayOf(i, j)
            }
        }
        fun go(i: Int, j: Int, steps: Int = -1): Int {
            if (t[0] == i && t[1] == j) {
                if (steps == total)
                    ++paths
                return 0
            }
            arrayOf(i to j + 1, i + 1 to j, i to j - 1, i - 1 to j).forEach { (u, v) ->
                if (0 <= u && u < M && 0 <= v && v < N && (A[u][v] == 0 || A[u][v] == 2)) {
                    A[u][v] = -1
                    go(u, v, steps + 1)
                    A[u][v] = 0
                }
            }
            return paths
        }
        return go(s[0], s[1])
    }
}

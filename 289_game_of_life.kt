/*
 * 289. Game of Life
 *
 * Q: https://leetcode.com/problems/game-of-life/
 * A: https://leetcode.com/problems/game-of-life/discuss/607337/Kt-Js-Py3-Cpp-In-Place-LIVE-or-DIE
 */

class Solution {
    fun gameOfLife(A: Array<IntArray>): Unit {
        var M = A.size
        var N = A[0].size
        for (i in 0 until M) {
            for (j in 0 until N) {
                var k = 0
                listOf<Pair<Int, Int>>(i - 1 to j, i - 1 to j + 1, i to j + 1, i + 1 to j + 1, i + 1 to j, i + 1 to j - 1, i to j - 1, i - 1 to j - 1).forEach { (u, v) ->
                    if (u in 0..M - 1 && v in 0..N - 1 && 0 < A[u][v])
                        ++k
                }
                if (0 < A[i][j])
                    A[i][j] = if (k == 2 || k == 3) k else 1              // 🙂 live cells must have 2 or 3 adjacent live cells to stay alive, otherwise k = 1 (special case)
                else
                    A[i][j] = -k                                          // 👻 dead cells have -k adjacent live cells
            }
        }
        for (i in 0 until M)
            for (j in 0 until N)
                if (0 < A[i][j])
                    A[i][j] = if (A[i][j] == 2 || A[i][j] == 3) 1 else 0  // 🙂 live cells must have 2 or 3 adjacent live cells to stay alive
                else
                    A[i][j] = if (A[i][j] == -3) 1 else 0                 // 👻 dead cells become alive with 3 adjacent live cells
    }
}

/*
 * 1368. Minimum Cost to Make at Least One Valid Path in a Grid
 *
 * Q: https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/
 * A: https://leetcode.com/problems/minimum-cost-to-make-at-least-one-valid-path-in-a-grid/discuss/529142/Kt-Js-Py3-Cpp-BFS
 */

class Solution {
    fun minCost(A: Array<IntArray>): Int {
        var M = A.size
        var N = A[0].size
        var best = Array(M) { IntArray(N) { (1e9 + 7).toInt() } }
        best[0][0] = 0
        var dirs = arrayOf(arrayOf(0, 1), arrayOf(0, -1), arrayOf(1, 0), arrayOf(-1, 0))
        var q: Queue<Triple<Int, Int, Int>> = LinkedList<Triple<Int, Int, Int>>(mutableListOf(Triple(0, 0, 0)))
        var seen = mutableSetOf<String>();
        while (0 < q.size) {
            var (i, j, cost) = q.poll()
            dirs.forEachIndexed { dir, (di, dj) ->
                var u = i + di
                var v = j + dj
                var w = cost + (if (A[i][j] != dir + 1) 1 else 0)
                var key = "$u,$v,$w"
                if (0 <= u && u < M && 0 <= v && v < N && !seen.contains(key) && w < best[u][v]) {
                    q.add(Triple(u, v, w))
                    seen.add(key)
                    best[u][v] = w
                }
            }
        }
        return best[M - 1][N - 1]
    }
}

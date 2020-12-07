/*
 * 59. Spiral Matrix II
 *
 * Q: https://leetcode.com/problems/spiral-matrix-ii/
 * A: https://leetcode.com/problems/spiral-matrix-ii/discuss/430457/Kt-Js-Py3-Cpp-Step-and-Turn-Right
 */

class Solution {
    fun generateMatrix(N: Int): Array<IntArray> {
        var A = Array(N) { IntArray(N) }
        var i = 0
        var j = 0
        var k = 0
        var dirs = listOf<Pair<Int, Int>>(-1 to 0, 0 to 1, 1 to 0, 0 to -1)  // clockwise 👆, 👉, 👇, 👈
        fun turn() {
            k = (k + 1) % 4
        }
        fun step(): Boolean {
            var u = i + dirs[k].first
            var v = j + dirs[k].second
            if (0 <= u && u < N && 0 <= v && v < N && A[u][v] == 0) {
                i = u
                j = v
                return true
            }
            return false
        }
        var steps = 1
        A[0][0] = steps++
        while (steps <= N * N) {
            while (step())
                A[i][j] = steps++
            turn()
        }
        return A
    }
}

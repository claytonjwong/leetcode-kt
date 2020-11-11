/*
 * 593. Valid Square
 *
 * Q: https://leetcode.com/problems/valid-square/
 * A: https://leetcode.com/problems/valid-square/discuss/932012/Kt-Js-Py3-Cpp-Map
 */

class Solution {
    fun validSquare(a: IntArray, b: IntArray, c: IntArray, d: IntArray): Boolean {
        var m = mutableMapOf<Int, Int>()
        var f = { x1: Int, y1: Int, x2: Int, y2: Int -> Math.abs(x1 - x2) + Math.abs(y1 - y2) }
        var A = arrayOf(a, b, c, d)
        for (i in 0 until 4) {
            for (j in i + 1 until 4) {
                var dist = f(A[i][0], A[i][1], A[j][0], A[j][1])
                m[dist] = if (m.contains(dist)) m[dist]!!.plus(1) else 1
            }
        }
        return m.size <= 2 && m.all{ (x, cnt) -> 0 < x && (cnt == 2 || cnt == 4 || cnt == 6) }
    }
}

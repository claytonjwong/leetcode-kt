/*
 * 1620. Coordinate With Maximum Network Quality
 *
 * Q: https://leetcode.com/problems/coordinate-with-maximum-network-quality/
 * A: https://leetcode.com/problems/coordinate-with-maximum-network-quality/discuss/898691/Kt-Js-Py3-Cpp-Brute-Force
 */

class Solution {
    fun bestCoordinate(A: Array<IntArray>, radius: Int): IntArray {
        var N = A.size
        var quality = IntArray(N)
        A.sortWith(compareBy({ it[0] }, { it[1] }))             // lexicographical order
        fun dist(x1: Int, x2: Int, y1: Int, y2: Int): Double {  // euclidean distance
            var x = Math.abs(x1 - x2).toDouble()
            var y = Math.abs(y1 - y2).toDouble()
            return Math.sqrt(x * x + y * y)
        }
        for (i in 0 until N) {
            var (x1, y1, q1) = A[i]
            quality[i] = q1
            for (j in 0 until N) {
                if (i == j)
                    continue
                var (x2, y2, q2) = A[j]
                var d = dist(x1, x2, y1, y2)
                if (radius.toDouble() < d)
                    continue
                quality[i] += (q2 / (1 + d)).toInt()
            }
        }
        var i = quality.indices.maxBy { quality[it] }!!
        return A[i].slice(0..1).toIntArray()
    }
}

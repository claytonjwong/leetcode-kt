/*
 * 1711. Count Good Meals
 *
 * Q: https://leetcode.com/problems/count-good-meals/
 * A: https://leetcode.com/problems/count-good-meals/discuss/1001864/Kt-Js-Py3-Cpp-Map-%2B-Brute-Force-Search
 */

class Solution {
    fun countPairs(A: IntArray): Int {
        var mod = (1e9 + 7).toLong()
        var cnt = 0
        var m = mutableMapOf<Long, Int>()
        A.map{ it.toLong() }.forEach { x ->
            var t: Long = 1
            while (t <= (100 * 1e9).toLong()) {
                var y: Long = t - x
                if (m.contains(y))
                    cnt = ((cnt + m[y]!!) % mod).toInt()
                t = t shl 1
            }
            m[x] = 1 + m.getOrDefault(x, 0)
        }
        return cnt
    }
}

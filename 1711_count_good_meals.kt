/*
 * 1711. Count Good Meals
 *
 * Q: https://leetcode.com/problems/count-good-meals/
 * A: https://leetcode.com/problems/count-good-meals/discuss/1001864/Kt-Js-Py3-Cpp-Map-%2B-Brute-Force-Search
 */

class Solution {
    fun countPairs(A: IntArray): Int {
        var cnt = 0
        var m = mutableMapOf<Int, Int>()
        A.forEach { x ->
            var t = 1
            while (t <= 1 shl 21) {
                var y = t - x
                if (m.contains(y))
                    cnt = (cnt + m[y]!!) % (1e9 + 7).toInt()
                t = t shl 1
            }
            m[x] = 1 + m.getOrDefault(x, 0)
        }
        return cnt
    }
}

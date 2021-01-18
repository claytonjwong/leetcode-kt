/*
 * 1679. Max Number of K-Sum Pairs
 *
 * Q: https://leetcode.com/problems/max-number-of-k-sum-pairs/
 * A: https://leetcode.com/problems/max-number-of-k-sum-pairs/discuss/962118/Kt-Js-Py3-Cpp-Map
 */
class Solution {
    fun maxOperations(A: IntArray, T: Int): Int {
        var cnt = 0
        var m = mutableMapOf<Int, Int>()
        A.forEach { x ->
            var y = T - x
            if (m.contains(y) && 0 < m[y]!!) {
                m[y] = -1 + m.getOrDefault(y, 0); ++cnt
            } else {
                m[x] =  1 + m.getOrDefault(x, 0)
            }
        }
        return cnt
    }
}

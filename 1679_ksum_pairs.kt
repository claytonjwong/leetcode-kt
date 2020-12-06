/*
 * 1679. Max Number of K-Sum Pairs
 *
 * Q: https://leetcode.com/problems/max-number-of-k-sum-pairs/
 * A: https://leetcode.com/problems/max-number-of-k-sum-pairs/discuss/962118/Kt-Js-Py3-Cpp-Map
 */

class Solution {
    fun maxOperations(A: IntArray, k: Int): Int {
        var pairs = 0
        var m = mutableMapOf<Int, Int>()
        A.forEach { x ->
            var y = k - x
            if (!m.contains(y)) {
                m[x] = if (m.contains(x)) m[x]!!.plus(1) else 1
            } else {
                ++pairs
                m[y] = m[y]!!.minus(1)
                if (m[y] == 0)
                    m.remove(y)
            }
        }
        return pairs
    }
}

/*
 * 1564. Put Boxes Into the Warehouse I
 *
 * Q: https://leetcode.com/problems/put-boxes-into-the-warehouse-i/
 * A: https://leetcode.com/problems/put-boxes-into-the-warehouse-i/discuss/817303/Kt-Js-Py3-Cpp-Greedy
 */

class Solution {
    fun maxBoxesInWarehouse(box: IntArray, spot: IntArray): Int {
        var cnt = 0
        // 1. preprocess the boxes and spots
        box.sort()
        box.reverse()
        for (j in 1 until spot.size)
            spot[j] = Math.min(spot[j], spot[j - 1])
        // 2. greedily place i-th min box into j-th min spot (if it fits) from 👈 right-to-left
        var i = box.lastIndex
        var j = spot.lastIndex
        while (0 <= i && 0 <= j) {
            if (box[i] <= spot[j]) {  // ✅ i-th min box fits in j-th min spot
                ++cnt; --i; --j
            } else {                  // 🚫 try next monotonically non-decreasing j-th min spot
                --j
            }
        }
        return cnt
    }
}

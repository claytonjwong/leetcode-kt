/*
 * 1710. Maximum Units on a Truck
 *
 * Q: https://leetcode.com/problems/maximum-units-on-a-truck/
 * A: https://leetcode.com/problems/maximum-units-on-a-truck/discuss/999095/Kt-Js-Py3-Cpp-BEST-Greedily-TAKE-BOXES-while-we-HAVE-room
 */

class Solution {
    fun maximumUnits(A: Array<IntArray>, K: Int): Int {
        var best = 0
        var have = K
        A.sortWith(Comparator{ a: IntArray, b: IntArray -> b[1] - a[1] })
        A.forEach{ (boxes, units) ->
            var take = Math.min(have, boxes)
            best += take * units
            have -= take
        }
        return best
    }
}

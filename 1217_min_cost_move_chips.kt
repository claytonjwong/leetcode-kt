/*
 * 1217. Minimum Cost to Move Chips to The Same Position
 *
 * Q: https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/
 * A: https://leetcode.com/problems/minimum-cost-to-move-chips-to-the-same-position/discuss/399869/Kt-Js-Py3-Cpp-Minimum-Odd-and-Even
 */

// concise
class Solution {
    fun minCostToMoveChips(A: IntArray): Int {
        return Math.min(A.filter{ x -> x and 1 == 1 }.size, A.filter{ x -> x and 1 == 0 }.size)
    }
}

// verbose
class Solution {
    fun minCostToMoveChips(A: IntArray): Int {
        var odd = 0
        var even = 0
        A.forEach { x ->
            if (x and 1 == 1)
                ++odd
            else
                ++even
        }
        return Math.min(odd, even)
    }
}

/*
 * 1672. Richest Customer Wealth
 *
 * Q: https://leetcode.com/problems/richest-customer-wealth/
 * A: https://leetcode.com/problems/richest-customer-wealth/discuss/952772/Kt-Js-Py3-Cpp-1-Liners
 */

class Solution {
    fun maximumWealth(A: Array<IntArray>): Int {
        return A.map{ it.sum() }.max()!!
    }
}

// verbose
class Solution {
    fun maximumWealth(A: Array<IntArray>): Int {
        return A.map{ row -> row.sum() }.max()!!
    }
}

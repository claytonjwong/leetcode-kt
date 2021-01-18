/*
 * 339. Nested List Weight Sum
 *
 * Q: https://leetcode.com/problems/nested-list-weight-sum/
 * A: https://leetcode.com/problems/nested-list-weight-sum/discuss/124490/Kt-Js-Py3-Cpp-Recursive
 */

class Solution {
    fun depthSum(A: List<NestedInteger>, depth: Int = 1): Int {
        var total = 0
        A.forEach {
            if (it.isInteger())
                total += it.getInteger() * depth
            else
                total += depthSum(it.getList(), depth + 1)
        }
        return total
    }
}

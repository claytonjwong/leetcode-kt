/*
 * 1026. Maximum Difference Between Node and Ancestor
 *
 * Q: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/
 * A: https://leetcode.com/problems/maximum-difference-between-node-and-ancestor/discuss/390492/Kt-Js-Py3-Cpp-Pre-Order-Traversal
 */

class Solution {
    fun maxAncestorDiff(root: TreeNode?): Int {
        fun go(root: TreeNode?, lo: Int, hi: Int): Int {
            if (root == null)
                return Math.abs(lo - hi)
            var next_lo = Math.min(lo, root!!.`val`)
            var next_hi = Math.max(hi, root!!.`val`)
            return Math.max(go(root.left, next_lo, next_hi), go(root.right, next_lo, next_hi))
        }
        return go(root, root!!.`val`, root!!.`val`)
    }
}

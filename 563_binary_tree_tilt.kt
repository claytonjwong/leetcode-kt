/*
 * 563. Binary Tree Tilt
 *
 * Q: https://leetcode.com/problems/binary-tree-tilt/
 * A: https://leetcode.com/problems/binary-tree-tilt/discuss/928266/Kt-Js-Py3-Cpp-Post-Order-Traversal
 */

class Solution {
    fun findTilt(root: TreeNode?): Int {
        var total = 0
        fun go(root: TreeNode?): Int {
            if (root == null)
                return 0
            var L = go(root.left)
            var R = go(root.right)
            total += Math.abs(L - R)
            return root.`val` + L + R
        }
        go(root)
        return total
    }
}

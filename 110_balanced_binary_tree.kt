/*
 * 110. Balanced Binary Tree
 *
 * Q: https://leetcode.com/problems/balanced-binary-tree/
 * A: https://leetcode.com/problems/balanced-binary-tree/discuss/981963/Kt-Js-Py3-Cpp-Post-Order-Traversal
 */

class Solution {
    fun isBalanced(root: TreeNode?): Boolean {
        var ok = true
        fun go(root: TreeNode?): Int {
            if (root == null)
                return 0
            var L = 1 + go(root.left)
            var R = 1 + go(root.right)
            if (1 < Math.abs(L - R))
                ok = false
            return Math.max(L, R)
        }
        go(root)
        return ok
    }
}

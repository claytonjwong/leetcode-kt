/*
 * 104. Maximum Depth of Binary Tree
 *
 * Q: https://leetcode.com/problems/maximum-depth-of-binary-tree/
 * A: https://leetcode.com/problems/maximum-depth-of-binary-tree/discuss/955868/Kt-Js-Py3-Cpp-1-Liners
 */

class Solution {
    fun maxDepth(root: TreeNode?): Int {
        return if (root == null) 0 else 1 + Math.max(maxDepth(root!!.left), maxDepth(root!!.right))
    }
}

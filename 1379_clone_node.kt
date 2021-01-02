/*
 * 1379. Find a Corresponding Node of a Binary Tree in a Clone of That Tree
 *
 * Q: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/
 * A: https://leetcode.com/problems/find-a-corresponding-node-of-a-binary-tree-in-a-clone-of-that-tree/discuss/537655/Kt-Js-Py3-Cpp-Traverse-A%2BB-Simultaneously
 */

class TreeNode(var `val`: Int) {
    var left: TreeNode? = null
    var right: TreeNode? = null
}

class Solution {
    fun getTargetCopy(A: TreeNode?, B: TreeNode?, T: TreeNode?): TreeNode? {
        fun go(a: TreeNode? = A, b: TreeNode? = B): TreeNode? {
            if (a == T)
                return b
            var L = if (a?.left != null)  go(a?.left, b?.left)   else null
            var R = if (a?.right != null) go(a?.right, b?.right) else null
            return if (L != null) L else R
        }
        return go()
    }
}

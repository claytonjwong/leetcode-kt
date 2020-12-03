/*
 * 897. Increasing Order Search Tree
 *
 * Q: https://leetcode.com/problems/increasing-order-search-tree/
 * A: https://leetcode.com/problems/increasing-order-search-tree/discuss/165898/Kt-Js-Py3-Cpp-solutions
 */

class Solution {
    fun increasingBST(root: TreeNode?): TreeNode? {
        var A = mutableListOf<TreeNode?>()
        fun go(root: TreeNode?) {
            if (root == null)
                return
            go(root!!.left)
            A.add(root)
            go(root!!.right)
            root!!.left = null
            root!!.right = null
        }
        go(root)
        var sentinel: TreeNode? = TreeNode(-1)
        var cur = sentinel
        A.forEach{
            cur!!.right = it
            cur = cur!!.right
        }
        return sentinel!!.right
    }
}

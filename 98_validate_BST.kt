/*
 * 98. Validate Binary Search Tree
 *
 * Q: https://leetcode.com/problems/validate-binary-search-tree/
 * A: https://leetcode.com/problems/validate-binary-search-tree/discuss/116826/Kt-Js-Py3-Cpp-Recursive
 */

class Solution {
    fun isValidBST(root: TreeNode?, lo: Long = -(6e9).toLong(), hi: Long = (6e9).toLong()): Boolean {
        if (root == null)
            return true
        if (root?.`val` <= lo || hi <= root?.`val`)
            return false
        return isValidBST(root?.left, lo, root?.`val`.toLong()) && isValidBST(root?.right, root?.`val`.toLong(), hi)
    }
}

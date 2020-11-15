/*
 * 938. Range Sum of BST
 *
 * Q: https://leetcode.com/problems/range-sum-of-bst/
 * A: https://leetcode.com/problems/range-sum-of-bst/discuss/192070/Kt-Js-Py3-Cpp-solutions
 */

class Solution {
    fun rangeSumBST(root: TreeNode?, lo: Int, hi: Int): Int {
        if (root == null)
            return 0
        var x = if (lo <= root?.`val` && root?.`val` <= hi) root?.`val` else 0
        return x + rangeSumBST(root.left, lo, hi) + rangeSumBST(root.right, lo, hi)
    }
}

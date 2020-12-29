/*
 * 1457. Pseudo-Palindromic Paths in a Binary Tree
 *
 * Q: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/
 * A: https://leetcode.com/problems/pseudo-palindromic-paths-in-a-binary-tree/discuss/652445/Kt-Js-Py3-Cpp-Map
 */

class Solution {
    fun pseudoPalindromicPaths (root: TreeNode?): Int {
        var m = mutableMapOf<Int, Int>()
        var odd = 0
        var paths = 0
        fun go(root: TreeNode?) {
            var x = root!!.`val`
            m[x] =  1 + m.getOrDefault(x, 0); odd += if (m[x]!! % 2 == 1) 1 else -1
            if (root?.left == null && root?.right == null && odd <= 1)
                ++paths
            if (root?.left  != null) go(root?.left)
            if (root?.right != null) go(root?.right)
            m[x] = -1 + m.getOrDefault(x, 0); odd += if (m[x]!! % 2 == 1) 1 else -1
        }
        go(root)
        return paths
    }
}

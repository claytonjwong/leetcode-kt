/*
 * 337. House Robber III
 *
 * Q: https://leetcode.com/problems/house-robber-iii/
 * A: https://leetcode.com/problems/house-robber-iii/discuss/946524/Kt-Js-Py3-Cpp-The-ART-of-Dynamic-Programming
 */

// DFS
class Solution {
    fun rob(root: TreeNode?, INF: Int = (1e9 + 7).toInt()): Int {
        fun go(root: TreeNode?, isRobbable: Boolean = true): Int {
            if (root == null)
                return 0
            var include = go(root?.left, false) + go(root?.right, false) + root?.`val`
            var exclude = go(root?.left, true)  + go(root?.right, true)
            return Math.max(if (isRobbable) include else -INF, exclude)
        }
        return go(root)
    }
}

// Memo
class Solution {
    fun rob(root: TreeNode?, INF: Int = (1e9 + 7).toInt()): Int {
        var m = mutableMapOf<String, Int>()
        fun go(root: TreeNode?, isRobbable: Boolean = true): Int {
            var key = "$root,$isRobbable"
            if (m.contains(key))
                return m[key]!!
            if (root == null) {
                m[key] = 0
                return m[key]!!
            }
            var include = go(root?.left, false) + go(root?.right, false) + root?.`val`
            var exclude = go(root?.left, true)  + go(root?.right, true)
            m[key] = Math.max(if (isRobbable) include else -INF, exclude)
            return m[key]!!
        }
        return go(root)
    }
}

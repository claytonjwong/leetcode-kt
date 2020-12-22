/*
 * 1602. Find Nearest Right Node in Binary Tree
 *
 * Q: https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/
 * A: https://leetcode.com/problems/find-nearest-right-node-in-binary-tree/discuss/875464/Kt-Js-Py3-Cpp-DFS-and-BFS
 */

// DFS
class Solution {
    fun findNearestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
        var found = -1
        fun go(v: TreeNode? = root, depth: Int = 0): TreeNode? {
            if (v == null)
                return null
            if (found == depth)
                return v
            if (u == v)
                found = depth
            var L = go(v?.left,  1 + depth)
            var R = go(v?.right, 1 + depth)
            if (L != null) return L
            if (R != null) return R
            return null
        }
        return go()
    }
}

// BFS
class Solution {
    fun findNearestRightNode(root: TreeNode?, u: TreeNode?): TreeNode? {
        var q: Queue<TreeNode?> = LinkedList<TreeNode?>(mutableListOf(root))
        while (0 < q.size) {
            var k = q.size
            while (0 < k--) {
                var v = q.poll()
                if (u == v)
                    return if (0 < k) q.poll() else null
                if (v?.left  != null) q.add(v?.left)
                if (v?.right != null) q.add(v?.right)
            }
        }
        return null
    }
}

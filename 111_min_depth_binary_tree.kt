/*
 * 111. Minimum Depth of Binary Tree
 *
 * Q: https://leetcode.com/problems/minimum-depth-of-binary-tree/
 * A: https://leetcode.com/problems/minimum-depth-of-binary-tree/discuss/553010/Kt-Js-Py3-Cpp-DFS-%2B-BFS
 */

// DFS
class Solution {
    fun minDepth(root: TreeNode?): Int {
        fun go(node: TreeNode?, depth: Int): Int {
            if (node?.left == null && node?.right == null)
                return depth
            var L = if (node?.left  != null) go(node?.left,  depth + 1) else Int.MAX_VALUE
            var R = if (node?.right != null) go(node?.right, depth + 1) else Int.MAX_VALUE
            return Math.min(L, R)
        }
        return if (root != null) go(root, 1) else 0
    }
}

// BFS
class Solution {
    fun minDepth(root: TreeNode?): Int {
        if (root == null)
            return 0
        var depth = 1
        var q: Queue<TreeNode?> = LinkedList<TreeNode?>(mutableListOf(root))
        while (q.peek() != null) {
            var k = q.size
            while (k-- != 0) {
                var cur = q.poll()
                if (cur?.left == null && cur?.right == null)
                    return depth
                if (cur?.left != null)  q.add(cur?.left)
                if (cur?.right != null) q.add(cur?.right)
            }
            ++depth
        }
        return -1
    }
}

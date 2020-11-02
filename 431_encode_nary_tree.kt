/*
 * 431. Encode N-ary Tree to Binary Tree
 *
 * Q: https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/
 * A: https://leetcode.com/problems/encode-n-ary-tree-to-binary-tree/discuss/920789/Kt-Js-Py3-Cpp-Recursive-Copy
 */

class Codec {
    fun encode(parent: Node?): TreeNode? {
        if (parent == null)
            return null
        var copy = TreeNode(parent.`val`)
        var next = TreeNode(-1)
        parent.children.forEach { child ->
            if (next.`val` != -1) {
                next.right = encode(child)
                next = next?.right
            } else {
                copy.left = encode(child)
                next = copy.left
            }
        }
        return copy
    }
    fun decode(parent: TreeNode?): Node? {
        if (parent == null)
            return null
        var children = mutableListOf<Node?>()
        var next = parent.left
        while (next != null) {
            children.add(decode(next))
            next = next?.right
        }
        var copy = Node(parent.`val`)
        copy.children = children
        return copy
    }
}

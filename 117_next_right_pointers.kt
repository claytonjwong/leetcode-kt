/*
 * 117. Populating Next Right Pointers in Each Node II
 *
 * Q: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/
 * A: https://leetcode.com/problems/populating-next-right-pointers-in-each-node-ii/discuss/706949/Kt-Js-Py3-Cpp-BFS
 */

class Solution {
    fun connect(root: Node?): Node? {
        if (root == null)
            return null
        var q: Queue<Node?> = LinkedList<Node?>(mutableListOf(root))
        while (0 < q.size) {
            var k = q.size
            while (0 < k) {
                var cur = q.poll(); --k
                cur!!.next = if (0 < k) q.peek() else null
                if (cur!!.left  != null) q.add(cur!!.left)
                if (cur!!.right != null) q.add(cur!!.right)
            }
        }
        return root
    }
}

/*
 * 133. Clone Graph
 *
 * Q: https://leetcode.com/problems/clone-graph/
 * A: https://leetcode.com/problems/clone-graph/discuss/613748/Kt-Js-Py3-Cpp-DFS-%2B-BFS-via-Map
 */

// DFS
class Solution {
    private var m = mutableMapOf<Int, Node?>()
    fun cloneGraph(cur: Node?): Node? {
        if (cur == null)
            return null
        if (m[cur!!.`val`] != null)
            return m[cur!!.`val`]
        m[cur!!.`val`] = Node(cur!!.`val`)
        cur!!.neighbors.forEach { adj ->
            m[cur!!.`val`]!!.neighbors.add(cloneGraph(adj))
        }
        return m[cur!!.`val`]
    }
}

// BFS
class Solution {
    fun cloneGraph(start: Node?): Node? {
        if (start == null)
            return null
        var m = mutableMapOf<Int, Node?>()
        var q: Queue<Node?> = LinkedList<Node?>(mutableListOf(start))
        var seen = mutableSetOf(start!!.`val`)
        while (q.peek() != null) {
            var cur = q.poll()
            m[cur!!.`val`] = if (m.contains(cur!!.`val`)) m[cur!!.`val`] else Node(cur!!.`val`)
            cur!!.neighbors.forEach { adj ->
                m[adj!!.`val`] = if (m.contains(adj!!.`val`)) m[adj!!.`val`] else Node(adj!!.`val`)
                m[cur!!.`val`]!!.neighbors.add(m[adj!!.`val`])
                if (!seen.contains(adj!!.`val`)) {
                    q.add(adj)
                    seen.add(adj!!.`val`)
                }
            }
        }
        return m[start!!.`val`]
    }
}

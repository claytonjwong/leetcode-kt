/*
 * 1506. Find Root of N-Ary Tree
 *
 * Q: https://leetcode.com/problems/find-root-of-n-ary-tree/
 * A: https://leetcode.com/problems/find-root-of-n-ary-tree/discuss/729168/Kt-Js-Py3-Cpp-O(N)-%2B-O(1)-memory-solutions
 */

// naive
class Solution {
    fun findRoot(A: List<Node>): Node? {
        var children = mutableSetOf<Node?>()
        A.forEach{
            it!!.children.forEach{ child -> children.add(child) }
        }
        return A.filter{ !children.contains(it) }[0]
    }
}

// memory optimized
class Solution {
    fun findRoot(A: List<Node>): Node? {
        var x = 0
        A.forEach{
            x = x xor it!!.`val`
            it!!.children.forEach{ child -> x = x xor child!!.`val` }
        }
        return A.filter{ x == it!!.`val` }[0]
    }
}

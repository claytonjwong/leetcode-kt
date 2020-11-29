/*
 * 1306. Jump Game III
 *
 * Q: https://leetcode.com/problems/jump-game-iii/
 * A: https://leetcode.com/problems/jump-game-iii/discuss/464420/Kt-Js-Py3-Cpp-BFS-%2B-DFS
 */

// BFS
class Solution {
    fun canReach(A: IntArray, start: Int): Boolean {
        var seen = mutableSetOf<Int>()
        var q: Queue<Int> = LinkedList<Int>(mutableListOf(start))
        while (0 < q.size) {
            var i = q.poll()
            if (A[i] == 0)
                return true
            intArrayOf(i + A[i], i - A[i]).forEach{
                if (0 <= it && it < A.size && !seen.contains(it)) {
                    q.add(it); seen.add(it)
                }
            }
        }
        return false
    }
}

// DFS
class Solution {
    fun canReach(A: IntArray, start: Int): Boolean {
        var seen = mutableSetOf<Int>()
        fun go(i: Int = start): Boolean {
            if (i < 0 || A.size <= i || seen.contains(i))
                return false
            seen.add(i)
            if (A[i] == 0)
                return true
            return go(i + A[i]) || go(i - A[i])
        }
        return go()
    }
}

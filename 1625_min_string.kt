/*
 * 1625. Lexicographically Smallest String After Applying Operations
 *
 * Q: https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/
 * A: https://leetcode.com/problems/lexicographically-smallest-string-after-applying-operations/discuss/903526/Kt-Js-Py3-Cpp-Brute-Force-via-DFS-%2B-BFS
 */

// DFS
class Solution {
    fun findLexSmallestString(s: String, amount: Int, pivot: Int): String {
        var ord: (Char) -> Int = { c: Char -> c.toInt() }
        var best = s
        var seen = mutableSetOf<String>()
        fun go(s: String): Unit {
            if (best > s)
                best = s
            var increment = s.mapIndexed{ i, c -> if (i % 2 == 1) (ord('0') + (ord(c) - ord('0') + amount) % 10).toChar() else c }.joinToString("")
            if (!seen.contains(increment)) {
                seen.add(increment); go(increment)
            }
            var rotate = s.substring(pivot) + s.substring(0, pivot)
            if (!seen.contains(rotate)) {
                seen.add(rotate); go(rotate)
            }
        }
        go(s)
        return best
    }
}

// BFS
class Solution {
    fun findLexSmallestString(s: String, amount: Int, pivot: Int): String {
        var ord: (Char) -> Int = { c: Char -> c.toInt() }
        var best = s
        var seen = mutableSetOf<String>()
        var q: Queue<String> = LinkedList<String>(mutableListOf(s))
        while (q.peek() != null) {
            var cur = q.poll()
            if (best > cur)
                best = cur
            var increment = cur.mapIndexed{ i, c -> if (i % 2 == 1) (ord('0') + (ord(c) - ord('0') + amount) % 10).toChar() else c }.joinToString("")
            if (!seen.contains(increment)) {
                seen.add(increment); q.add(increment)
            }
            var rotate = cur.substring(pivot) + cur.substring(0, pivot)
            if (!seen.contains(rotate)) {
                seen.add(rotate); q.add(rotate)
            }
        }
        return best
    }
}

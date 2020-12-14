/*
 * 131. Palindrome Partitioning
 *
 * Q: https://leetcode.com/problems/palindrome-partitioning/
 * A: https://leetcode.com/problems/palindrome-partitioning/discuss/972094/Kt-Js-Py3-Cpp-DFS-%2B-BT
 */

class Solution {
    fun partition(s: String): List<List<String>> {
        var N = s.length
        var paths = mutableListOf<List<String>>()
        var ok = { A: MutableList<Char> -> A.joinToString("") == A.joinToString("").reversed() }
        fun go(start: Int = 0, path: Stack<String> = Stack<String>()) {
            if (start == N) {
                paths.add(path.toList())
                return
            }
            var cand = mutableListOf<Char>()
            for (i in start until N) {
                cand.add(s[i])
                if (ok(cand)) {
                    path.push(cand.joinToString(""))
                    go(i + 1, path)
                    path.pop()
                }
            }
        }
        go()
        return paths
    }
}

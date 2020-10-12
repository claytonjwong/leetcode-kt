/*
 * 316. Remove Duplicate Letters
 *
 * Q: https://leetcode.com/problems/remove-duplicate-letters/
 * A: https://leetcode.com/problems/remove-duplicate-letters/discuss/890223/Kt-Js-Py3-C%2B%2B-Monotonic-Queue-%2B-Detailed-Explanation
 */

 class Solution {
    fun removeDuplicateLetters(s: String): String {
        var A = Stack<Char>()
        var have = mutableSetOf<Char>()
        var last = HashMap<Char, Int>()
        s.forEachIndexed { i, c ->
            last[c] = i
        }
        s.forEachIndexed { i, c ->
            while (!have.contains(c) && !A.empty() && c < A.peek() && i < last[A.peek()]!!) {
                have.remove(A.pop())
            }
            if (!have.contains(c)) {
                have.add(c)
                A.push(c)
            }
        }
        return A.joinToString("")
    }
}

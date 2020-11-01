/*
 * 1640. Check Array Formation Through Concatenation
 *
 * Q: https://leetcode.com/problems/check-array-formation-through-concatenation/
 * A: https://leetcode.com/problems/check-array-formation-through-concatenation/discuss/919391/Kt-Js-Py3-Cpp-Do-we-%22have%22-what-we-%22need%22
 */

class Solution {
    fun canFormArray(need: IntArray, have: Array<IntArray>): Boolean {
        var q: Queue<Int> = LinkedList<Int>()
        for (i in 0 until need.size) {
            var x = need[i]
            if (0 < q.size) {
                if (x != q.peek())
                    return false
                q.poll()
                continue
            }
            var found = false
            for (j in 0 until have.size) {
                if (x == have[j][0]) {
                    found = true
                    for (k in 1 until have[j].size)
                        q.add(have[j][k])
                    break
                }
            }
            if (!found)
                return false
        }
        return true
    }
}

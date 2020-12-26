/*
 * 1700. Number of Students Unable to Eat Lunch
 *
 * Q: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/
 * A: https://leetcode.com/problems/number-of-students-unable-to-eat-lunch/discuss/987305/Kt-Js-Py3-Cpp-Do-we-HAVE-what-we-NEED
 */

class Solution {
    fun countStudents(A: IntArray, B: IntArray): Int {
        var m = mutableMapOf<Int, Int>();
        A.forEach { m[it] = if (m.contains(it)) 1 + m[it]!! else 1 }
        var need: Queue<Int> = LinkedList<Int>(A.toList())
        var have: Queue<Int> = LinkedList<Int>(B.toList())
        while (0 < have.size && m.contains(have.peek()) && 0 < m[have.peek()]!!) {
            if (need.peek() != have.peek()) {
                need.add(need.poll())
                continue
            }
            var x = have.peek()
            m[x] = m[x]!!.minus(1)
            need.poll()
            have.poll()
        }
        return need.size
    }
}

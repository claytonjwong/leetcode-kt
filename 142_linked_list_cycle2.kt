/*
 * 142. Linked List Cycle II
 *
 * Q: https://leetcode.com/problems/linked-list-cycle-ii/
 * A: https://leetcode.com/problems/linked-list-cycle-ii/discuss/523559/Kt-Js-Py3-Cpp-Seen-ListNodes
 */

class Solution {
    fun detectCycle(head: ListNode?): ListNode? {
        var cur = head
        var seen = mutableSetOf<ListNode?>()
        while (cur != null) {
            if (seen.contains(cur))
                return cur
            seen.add(cur)
            cur = cur.next
        }
        return null
    }
}

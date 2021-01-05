/*
 * 82. Remove Duplicates from Sorted List II
 *
 * Q: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/
 * A: https://leetcode.com/problems/remove-duplicates-from-sorted-list-ii/discuss/590900/Kt-Js-Py3-Cpp-Single-Pass
 */

class Solution {
    fun deleteDuplicates(head: ListNode?): ListNode? {
        var sentinel = ListNode(-123); sentinel?.next = head
        var ans = sentinel
        var cur = head
        var pre = cur
        while (cur != null) {
            while (cur?.`val` == cur?.next?.`val`)
                cur = cur?.next
            if (pre == cur) {
                ans?.next = cur; ans = ans?.next
            }
            cur = cur?.next; pre = cur
        }
        ans?.next = null
        return sentinel?.next
    }
}

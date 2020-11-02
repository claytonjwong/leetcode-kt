/*
 * 147. Insertion Sort List
 *
 * Q: https://leetcode.com/problems/insertion-sort-list/
 * A: https://leetcode.com/problems/insertion-sort-list/discuss/920698/Kt-Js-Py3-Cpp-Sentinel-%2B-Last
 */

class Solution {
    fun insertionSortList(head: ListNode?): ListNode? {
        var sentinel = ListNode(-1); sentinel.next = head
        var last = head
        while (last != null && last.next != null) {
            // ✅ case 1: last.next is already in sorted order
            if (last.`val` < last.next.`val`) {
                last = last.next
                continue
            }
            // ❌ case 2: insert last.next somewhere after sentinel and before last
            var pre = sentinel
            while (pre.next.`val` < last.next.`val`)
                pre = pre.next
            var tmp = last.next.next
            last.next.next = pre.next
            pre.next = last.next
            last.next = tmp
        }
        return sentinel.next
    }
}

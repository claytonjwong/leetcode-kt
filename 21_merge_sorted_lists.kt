/*
 * 21. Merge Two Sorted Lists
 *
 * Q: https://leetcode.com/problems/merge-two-sorted-lists/
 * A: https://leetcode.com/problems/merge-two-sorted-lists/discuss/505426/Kt-Js-Py3-Cpp-Cherry-Pick-Minimum
 */

class Solution {
    fun mergeTwoLists(A_: ListNode?, B_: ListNode?): ListNode? {
        var A = A_
        var B = B_
        var sentinel = ListNode(-1)
        var tail = sentinel
        while (A != null && B != null) {
            if (A?.`val` < B?.`val`) {
                tail?.next = A; A = A?.next
            } else {
                tail?.next = B; B = B?.next
            }
            tail = tail?.next
        }
        if (A != null) tail?.next = A
        if (B != null) tail?.next = B
        return sentinel?.next
    }
}

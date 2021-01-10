/*
 * 1721. Swapping Nodes in a Linked List
 *
 * Q: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/
 * A: https://leetcode.com/problems/swapping-nodes-in-a-linked-list/discuss/1009772/Kt-Js-Py3-Cpp-Swap-based-upon-length-N
 */

class Solution {
    fun swapNodes(head: ListNode?, K: Int): ListNode? {
        var cur = head
        var N = 0; while (cur != null) { cur = cur.next; ++N }
        var i = K - 1
        var j = N - K
        var a = head
        var b = head
        while (0 < i--) { a = a?.next }
        while (0 < j--) { b = b?.next }
        a?.`val` = b?.`val`.also{ b?.`val` = a?.`val` }
        return head
    }
}

/*
 * 369. Plus One Linked List
 *
 * Q: https://leetcode.com/problems/plus-one-linked-list/
 * A: https://leetcode.com/problems/plus-one-linked-list/discuss/973286/Kt-Js-Py3-Cpp-Recursive-solutions
 */

class Solution {
    fun plusOne(head: ListNode?): ListNode? {
        fun go(node: ListNode?): Boolean {
            if (node == null)
                return false
            var carry = go(node?.next)
            if (carry || node?.next == null) {
                if (++node!!.`val` == 10) {
                    node!!.`val` = 0
                    return true
                }
            }
            return false
        }
        if (go(head)) {
            var pre: ListNode? = ListNode(1)
            pre!!.next = head
            return pre
        }
        return head
    }
}

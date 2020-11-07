/*
 * 445. Add Two Numbers II
 *
 * Q: https://leetcode.com/problems/add-two-numbers-ii/
 * A: https://leetcode.com/problems/add-two-numbers-ii/discuss/927269/Kt-Js-Py3-Cpp-Recursive-Reverse
 */

class Solution {
    fun addTwoNumbers(A: ListNode?, B: ListNode?): ListNode? {
        fun rev(cur: ListNode?, pre: ListNode? = null): ListNode? {
            if (cur?.next == null) {
                cur?.next = pre
                return cur
            }
            var next = cur?.next
            cur?.next = pre
            return rev(next, cur)
        }
        var a = rev(A)
        var b = rev(B)
        var ans = ListNode(-1)
        var cur = ans
        var carry = 0
        while (a != null || b != null) {
            var c = (a?.`val` ?: 0) + (b?.`val` ?: 0) + carry
            carry = if (10 <= c) 1 else 0; c %= 10
            cur?.next = ListNode(c)
            cur = cur.next
            a = a?.next
            b = b?.next
        }
        if (carry == 1)
            cur?.next = ListNode(1)
        return rev(ans?.next)
    }
}

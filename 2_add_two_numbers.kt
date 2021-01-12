/*
 * 2. Add Two Numbers
 *
 * Q: https://leetcode.com/problems/add-two-numbers/
 * A: https://leetcode.com/problems/add-two-numbers/discuss/1093/Kt-Js-Py3-Cpp-Concise-solutions
 */

class Solution {
    fun addTwoNumbers(A_: ListNode?, B_: ListNode?): ListNode? {
        var A = A_
        var B = B_
        var ans = ListNode(-1)
        var cur = ans
        var carry = false
        while (A != null || B != null || carry) {
            var a = if (A != null) A?.`val` else 0
            var b = if (B != null) B?.`val` else 0
            var c = a + b + (if (carry) 1 else 0)
            carry = 10 <= c; c %= 10
            cur?.next = ListNode(c); cur = cur?.next
            A = A?.next
            B = B?.next
        }
        return ans.next
    }
}

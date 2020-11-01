/*
 * 1290. Convert Binary Number in a Linked List to Integer
 *
 * Q: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/
 * A: https://leetcode.com/problems/convert-binary-number-in-a-linked-list-to-integer/discuss/454225/Kt-Js-Py3-Cpp-Simple-solutions
 */

class Solution {
    fun getDecimalValue(head: ListNode?): Int {
        var ans = 0
        var cur = head
        while (cur != null) {
            ans = ans shl 1
            ans += cur.`val`
            cur = cur.next
        }
        return ans
    }
}

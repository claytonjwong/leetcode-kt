/*
 * 382. Linked List Random Node
 *
 * Q: https://leetcode.com/problems/linked-list-random-node/
 * A: https://leetcode.com/problems/linked-list-random-node/discuss/752830/Kt-Js-Py3-Cpp-solutions
 */

class Solution(head_: ListNode?) {

    private var N = 0
    private var head: ListNode?

    init {
        head = head_
        var cur = head
        while (cur != null) {
            ++N
            cur = cur!!.next
        }
    }

    fun getRandom(): Int {
        var cur = head
        var hops = Random().nextInt(N)
        while (0 < hops) {
            cur = cur!!.next
            --hops
        }
        return cur!!.`val`
    }
}

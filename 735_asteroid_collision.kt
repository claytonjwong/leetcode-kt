/*
 * 735. Asteroid Collision
 *
 * Q: https://leetcode.com/problems/asteroid-collision/
 * A: https://leetcode.com/problems/asteroid-collision/discuss/109683/Kt-Js-Py3-Cpp-Simulate-Collisions
 */

class Solution {
    fun asteroidCollision(A: IntArray): IntArray {
        var pre = A.copyOf(A.size)
        var ok = true
        do {
            ok = true
            var cur = mutableListOf<Int>()
            for (i in 0 until pre.size) {
                // ✅ case 1: no collision
                if (cur.size == 0 || cur.last() < 0 || (0 <= cur.last() && 0 <= pre[i])) {
                    cur.add(pre[i])
                    continue
                }
                // 🚫 case 2: 💥 collision
                ok = false
                var last = cur.last(); cur.removeAt(cur.lastIndex)
                if (Math.abs(last) != Math.abs(pre[i]))
                    cur.add(if (Math.abs(last) < Math.abs(pre[i])) pre[i] else last)
            }
            pre = cur.toIntArray()
        } while (!ok)
        return pre
    }
}

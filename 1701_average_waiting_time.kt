/*
 * 1701. Average Waiting Time
 *
 * Q: https://leetcode.com/problems/average-waiting-time/
 * A: https://leetcode.com/problems/average-waiting-time/discuss/987309/Kt-Js-Py3-Cpp-Average-Wait-Time
 */

class Solution {
    fun averageWaitingTime(A: Array<IntArray>): Double {
        var time = 0
        var last = 0
        var wait = mutableListOf<Double>()
        A.forEach { (i, j) ->
            time = Math.max(i, last)
            last = time + j
            wait.add(last - i.toDouble())
        }
        return wait.sum() / wait.size
    }
}

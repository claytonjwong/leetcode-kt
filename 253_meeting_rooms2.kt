/*
 * 253. Meeting Rooms II
 *
 * Q: https://leetcode.com/problems/meeting-rooms-ii/
 * A: https://leetcode.com/problems/meeting-rooms-ii/discuss/895910/Kt-Js-Py3-Cpp-Maximum-Overlap-via-Map
 */

class Solution {
    fun minMeetingRooms(A: Array<IntArray>): Int {
        var overlap = 0
        var maximum = 0
        var m = sortedMapOf<Int, Int>()
        A.forEach { (i, j) ->
            m[i] = m.getOrDefault(i, 0) + 1
            m[j] = m.getOrDefault(j, 0) - 1
        }
        m.forEach { (_, x) ->
            overlap += x; maximum = maxOf(maximum, overlap)
        }
        return maximum
    }
}

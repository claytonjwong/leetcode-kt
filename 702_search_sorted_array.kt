/*
 * 702. Search in a Sorted Array of Unknown Size
 *
 * Q: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/
 * A: https://leetcode.com/problems/search-in-a-sorted-array-of-unknown-size/discuss/906120/Kt-Js-Py3-Cpp-Binary-Search
 */

class Solution {
    fun search(reader: ArrayReader, T: Int): Int {
        var i = 0
        var j = 10000
        while (i < j) {
            var k = (i + j) / 2
            var cand = reader.get(k)
            if (cand == T)
                return k
            if (cand < T)
                i = k + 1
            else
                j = k
        }
        return -1
    }
}

/*
 * 1656. Design an Ordered Stream
 *
 * Q: https://leetcode.com/problems/design-an-ordered-stream/
 * A: https://leetcode.com/problems/design-an-ordered-stream/discuss/947961/Kt-Js-Py3-Cpp-Array
 */

class OrderedStream(N_: Int) {
    private var i = 0
    private var N = N_
    private var A = MutableList<String>(N) { "" }
    fun insert(k: Int, value: String): List<String> {
        var res = mutableListOf<String>()
        A[k - 1] = value  // -1 for 0-based indexing
        while (i < N && 0 < A[i].length)
            res.add(A[i++])
        return res
    }
}

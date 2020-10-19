/*
 * Kotlin version of C++ equal_range via lower_bound and upper_bound
 *
 * Gist: https://gist.github.com/claytonjwong/2f9c3b33f8697d77a1d442006d4947d6
 */

fun lowerBound(A: IntArray, target: Int): Int {
    val N = A.size
    var i = 0
    var j = N
    while (i < j) {
        val k = (i + j) / 2
        if (A[k] < target)
            i = k + 1
        else
            j = k
    }
    return i
}

fun upperBound(A: IntArray, target: Int): Int {
    val N = A.size
    var i = 0
    var j = N
    while (i < j) {
        val k = (i + j + 1) / 2
        if (k < N && A[k] <= target)
            i = k
        else
            j = k - 1
    }
    return j + 1
}

fun equalRange(A: IntArray, target: Int): Pair<Int, Int> {
    return Pair(lowerBound(A, target), upperBound(A, target))
}

fun main(args: Array<String>) {
    var A = intArrayOf(1, 1, 2, 2, 3, 3, 5, 5)
    //                 0  1  2  3  4  5  6  7  8
    println("2 is in range ${equalRange(A, 2)}") // 2 is in range (2, 4)
    println("4 is in range ${equalRange(A, 4)}") // 4 is in range (6, 6)
}

fun bubbleSort(arr: IntArray) {
    val n = arr.size
    for (i in 0 until n - 1) {
        var swapped = false
        for (j in 0 until n - i - 1) {
            if (arr[j] > arr[j + 1]) {
                val temp = arr[j]
                arr[j] = arr[j + 1]
                arr[j + 1] = temp
                swapped = true
            }
        }
        // If no two elements were swapped in the inner loop, the array is sorted
        if (!swapped) break
    }
}

fun main() {
    val arr = intArrayOf(5, 1, 4, 2, 8)
    bubbleSort(arr)
    println("Sorted array: ${arr.joinToString()}")
}

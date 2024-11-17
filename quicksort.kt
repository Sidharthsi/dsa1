fun quickSort(arr: IntArray, low: Int, high: Int) {
    if (low < high) {
        val pi = partition(arr, low, high)
        quickSort(arr, low, pi - 1) // Sort elements before pivot
        quickSort(arr, pi + 1, high) // Sort elements after pivot
    }
}

fun partition(arr: IntArray, low: Int, high: Int): Int {
    val pivot = arr[(low + high) / 2]
    var i = low
    var j = high

    while (i <= j) {
        while (arr[i] < pivot) i++
        while (arr[j] > pivot) j--
        if (i <= j) {
            val temp = arr[i]
            arr[i] = arr[j]
            arr[j] = temp
            i++
            j--
        }
    }
    return i
}

fun main() {
    val arr = intArrayOf(10, 7, 8, 9, 1, 5)
    quickSort(arr, 0, arr.size - 1)
    println("Sorted array: ${arr.joinToString()}")
}

fun binarySearch(arr: IntArray, target: Int): Int {
    var left = 0
    var right = arr.size - 1

    while (left <= right) {
        val mid = left + (right - left) / 2

        when {
            arr[mid] == target -> return mid // Found the target
            arr[mid] < target -> left = mid + 1 // Search in the right half
            else -> right = mid - 1 // Search in the left half
        }
    }

    return -1 // Target not found
}

fun main() {
    val arr = intArrayOf(10, 20, 30, 40, 50)
    val target = 30
    val result = binarySearch(arr, target)
    
    if (result != -1) {
        println("Element found at index $result")
    } else {
        println("Element not found")
    }
}

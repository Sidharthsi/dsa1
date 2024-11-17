class CircularLinkedList {

    // Node class
    data class Node(var data: Int, var next: Node? = null)

    private var tail: Node? = null

    // Insert at the beginning
    fun insertAtBeginning(data: Int) {
        val newNode = Node(data)
        if (tail == null) {
            newNode.next = newNode
            tail = newNode
        } else {
            newNode.next = tail?.next
            tail?.next = newNode
        }
    }

    // Insert at the end
    fun insertAtEnd(data: Int) {
        val newNode = Node(data)
        if (tail == null) {
            newNode.next = newNode
            tail = newNode
        } else {
            newNode.next = tail?.next
            tail?.next = newNode
            tail = newNode
        }
    }

    // Insert at a specific position (1-based index)
    fun insertAtPosition(data: Int, position: Int) {
        if (position < 1) {
            println("Invalid position")
            return
        }
        val newNode = Node(data)
        if (position == 1) {
            insertAtBeginning(data)
            if (tail == null) tail = newNode
            return
        }
        var temp = tail?.next
        var currentPosition = 1
        while (temp != null && currentPosition < position - 1) {
            temp = temp.next
            if (temp == tail?.next) break
            currentPosition++
        }
        if (temp == null || temp == tail) {
            println("Position out of bounds")
            return
        }
        newNode.next = temp.next
        temp.next = newNode
        if (temp == tail) {
            tail = newNode
        }
    }

    // Delete at the beginning
    fun deleteAtBeginning() {
        if (tail == null) {
            println("List is empty")
            return
        }
        if (tail?.next == tail) {
            tail = null
            return
        }
        tail?.next = tail?.next?.next
    }

    // Delete at the end
    fun deleteAtEnd() {
        if (tail == null) {
            println("List is empty")
            return
        }
        if (tail?.next == tail) {
            tail = null
            return
        }
        var temp = tail?.next
        while (temp?.next != tail) {
            temp = temp?.next
        }
        temp?.next = tail?.next
        tail = temp
    }
    

    // Delete at a specific position (1-based index)
    fun deleteAtPosition(position: Int) {
        if (position < 1) {
            println("Invalid position")
            return
        }
        if (tail == null) {
            println("List is empty")
            return
        }
        if (position == 1) {
            deleteAtBeginning()
            return
        }
        var temp = tail?.next
        var currentPosition = 1
        while (temp?.next != tail?.next && currentPosition < position - 1) {
            temp = temp?.next
            currentPosition++
        }
        if (temp == null || temp?.next == tail?.next || currentPosition != position - 1) {
            println("Position out of bounds")
            return
        }
        if (temp?.next == tail) {
            tail = temp
        }
        temp?.next = temp?.next?.next
    }
    

    // Display the list
    fun display() {
        if (tail == null) {
            println("List is empty")
            return
        }
        var temp = tail?.next
        do {
            print("${temp?.data} -> ")
            temp = temp?.next
        } while (temp != tail?.next)
        println()
    }
    
}
fun main() {
    val list = CircularLinkedList()

    // Initialize the list with predefined values
    val predefinedValues = listOf(5, 10, 15, 20)
    for (value in predefinedValues) {
        list.insertAtEnd(value)
    }
    println("Initialized list with predefined values:")
    list.display()

    // Insert at the beginning
    list.insertAtBeginning(2)
    println("\nAfter inserting 2 at the beginning:")
    list.display()

    // Insert at the end
    list.insertAtEnd(25)
    println("\nAfter inserting 25 at the end:")
    list.display()

    // Insert at a specific position
    list.insertAtPosition(12, 3)
    println("\nAfter inserting 12 at position 3:")
    list.display()

    // Delete at the beginning
    list.deleteAtBeginning()
    println("\nAfter deleting at the beginning:")
    list.display()

    // Delete at the end
    list.deleteAtEnd()
    println("\nAfter deleting at the end:")
    list.display()

    // Delete at a specific position
    list.deleteAtPosition(3)
    println("\nAfter deleting at position 3:")
    list.display()
}

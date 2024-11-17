class SinglyLinkedList {

    // Node class
    data class Node(var data: Int, var next: Node? = null)

    private var head: Node? = null

    // Insert at the beginning
    fun insertAtBeginning(data: Int) {
        val newNode = Node(data)
        newNode.next = head
        head = newNode
    }

    // Insert at the end
    fun insertAtEnd(data: Int) {
        val newNode = Node(data)
        if (head == null) {
            head = newNode
            return
        }
        var temp = head
        while (temp?.next != null) {
            temp = temp.next
        }
        temp?.next = newNode
    }

    // Insert at a specific position (1-based index)
    fun insertAtPosition(data: Int, position: Int) {
        if (position < 1) {
            println("Invalid position")
            return
        }
        val newNode = Node(data)
        if (position == 1) {
            newNode.next = head
            head = newNode
            return
        }
        var temp = head
        var currentPosition = 1
        while (temp != null && currentPosition < position - 1) {
            temp = temp.next
            currentPosition++
        }
        if (temp == null) {
            println("Position out of bounds")
            return
        }
        newNode.next = temp.next
        temp.next = newNode
    }

    // Delete at the beginning
    fun deleteAtBeginning() {
        if (head == null) {
            println("List is empty")
            return
        }
        head = head?.next
    }

    // Delete at the end
    fun deleteAtEnd() {
        if (head == null) {
            println("List is empty")
            return
        }
        if (head?.next == null) {
            head = null
            return
        }
        var temp = head
        while (temp?.next?.next != null) {
            temp = temp.next
        }
        temp?.next = null
    }

    // Delete at a specific position (1-based index)
    fun deleteAtPosition(position: Int) {
        if (position < 1) {
            println("Invalid position")
            return
        }
        if (head == null) {
            println("List is empty")
            return
        }
        if (position == 1) {
            head = head?.next
            return
        }
        var temp = head
        var currentPosition = 1
        while (temp != null && currentPosition < position - 1) {
            temp = temp.next
            currentPosition++
        }
        if (temp == null || temp.next == null) {
            println("Position out of bounds")
            return
        }
        temp.next = temp.next?.next
    }

    // Display the list
    fun display() {
        if (head == null) {
            println("List is empty")
            return
        }
        var temp = head
        while (temp != null) {
            print("${temp.data} -> ")
            temp = temp.next
        }
        println("NULL")
    }
}

fun main() {
    val list = SinglyLinkedList()

    // Insert at the beginning
    list.insertAtBeginning(10) // List: 10
    println("After inserting at the beginning (10):")
    list.display()

    // Insert at the end
    list.insertAtEnd(20) // List: 10 -> 20
    println("After inserting at the end (20):")
    list.display()

    // Insert at a specific position
    list.insertAtPosition(15, 2) // List: 10 -> 15 -> 20
    println("After inserting 15 at position 2:")
    list.display()

    // Delete at the beginning
    list.deleteAtBeginning()
    println("\nAfter deleting at the beginning:")
    list.display() // List: 15 -> 20

    // Delete at the end
    list.deleteAtEnd()
    println("\nAfter deleting at the end:")
    list.display() // List: 15

    // Delete at a specific position
    list.deleteAtPosition(1)
    println("\nAfter deleting at position 1:")
    list.display() // List: (Empty)
}

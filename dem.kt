class SinglyLinkedList{
    data class Node(var data:Int, var next: Node?= null)
    private  var head: Node?= null
    fun InsertAtBeginning(data:Int)
    {
        val newNode=Node(data)
        newNode.next=head
        head=newNode
    }
    fun InsertAtEnd(data:Int)
    {
       val newNode=Node(data)
       if(head==null){
        head=newNode
        return
    }
    var temp=head
    while(temp?.next != null)
    {
        temp=temp.next
    }
    temp?.next=newNode
    }

       }
    

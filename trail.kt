fun binarysearch(arr:IntArray,target:Int):Int{
    var left=0
    var right=arr.size-1
    while(left<=right){
        var mid=left+(right-left)/2
    
    when{
        arr[mid]==target->return mid 
        arr[mid] <  target ->left=mid+1
       else->right=mid-1
    }
    }
    return-1
    fun main(){
        var arr=intArrayOf (10,20,30,40,50)
        var target=30
        var result= binarysearch(arr,target)
        if(return!=-1){
        print("the index of search is $result")
        }
        else{
            println("the search not found")
        }
    }

}
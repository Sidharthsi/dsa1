fun linearsearch(arr : IntArray,target:Int):Int{
    for(i in arr.indices){
        if(arr[i]==target){
        return i
        }
    }
    return-1

}
fun main(){
   val arr=intArrayOf(10 , 20 , 30 , 40 , 50)
   val target=40
   val result=linearsearch(arr,target)
   if(result!=-1)
   {
      print("linear search index $result")

   }
   else{
    print("element not found")
   }
}
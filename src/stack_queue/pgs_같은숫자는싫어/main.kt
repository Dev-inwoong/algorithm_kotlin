package stack_queue.pgs_같은숫자는싫어

fun main(){
    var arr = arrayListOf(
        1, 1, 3, 3, 0, 1, 1
    )
    solution(arr)
}

fun solution(arr: ArrayList<Int>): ArrayList<Int> {
    var queue = ArrayList<Int>()
    for(num in arr){
        if (queue.isNotEmpty() && num == queue.last()){
            continue
        }else{
            queue.add(num)
        }
    }
    return queue
}
package stack_queue.pgs_프로세스

fun main(){
    var priorities = arrayListOf(
        1, 1, 9, 1, 1, 1
    )
    var location = 0
    println(solution(priorities, location))
}

fun solution(priorities : ArrayList<Int>, location : Int): Int? {
    var queue = HashMap<Int, Int>()
    var i  = 0
    var count = 1
    while (!priorities.all { it == Int.MIN_VALUE }){
        var process = priorities[i]

        // 이미 실행된 작업은 건너뜀
        if (process == Int.MIN_VALUE){
            i ++
            if (i == priorities.size){
                i = 0
            }
            continue
        }

        // 해당 작업이 남은 모든 작업의 우선순위보다 높으면
        if (priorities.all { it <= process }){
            priorities[i] = Int.MIN_VALUE
            queue[i] = count
            count ++
        }


        i ++
        if (i == priorities.size){
            i = 0
        }
    }

    println(queue)
    return queue[location]
}
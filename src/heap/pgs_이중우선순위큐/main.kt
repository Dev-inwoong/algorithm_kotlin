package heap.pgs_이중우선순위큐

import java.util.PriorityQueue

fun main(){
    val operations = arrayOf(
        "I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"
    )

    println(solution(operations).contentToString())
}

fun solution(operations: Array<String>): IntArray {
    var answer = intArrayOf()
    val priorityQueue = PriorityQueue<Int>()

    for (operation in operations) {
        val splt = operation.split(" ")
        val operator = splt.first()
        val n = splt.last().toInt()
        if (operator == "I"){ // input
            println("offer $n")
            priorityQueue.offer(n)
        }
        else{
            if (priorityQueue.isNotEmpty()){
                if (n == 1){ // remove maximum
                    print("remove maximum ")
                    println(priorityQueue.maxOrNull())
                    priorityQueue.remove(priorityQueue.maxOrNull())
                }else{ // remove minimum
                    print("remove minimum ")
                    println(priorityQueue.poll())
                }
            }else{
                println("empty queue")
            }
        }
        println("------- queue --------")
        println(priorityQueue)
        println("-----------------------")
        println()
    }
    answer = if (priorityQueue.isNotEmpty()){
        intArrayOf( // 최댓값, 최솟값
            priorityQueue.maxOrNull()!!, priorityQueue.peek()
        )
    }else{
        intArrayOf(
            0, 0
        )
    }

    return answer
}
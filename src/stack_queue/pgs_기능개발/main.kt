package stack_queue.pgs_기능개발

import kotlin.math.ceil

fun main(){
    var progresses = arrayListOf(
        95, 90, 99, 99, 80, 99
    )
    var speeds = arrayListOf(
        1, 1, 1, 1, 1, 1
    )
    solution(progresses, speeds)
}

fun solution(progresses : ArrayList<Int>, speeds : ArrayList<Int>): ArrayList<Int> {
    var processQueue = ArrayList<Int>()
    for (i in progresses.indices){
        var remainProcess = 100 - progresses[i] // 남은 작업량
        var doneDayProcess = ceil(remainProcess / speeds[i].toDouble())
        processQueue.add(doneDayProcess.toInt())
    }

    println(processQueue)

    var result = ArrayList<Int>() // 결과 값을 담을 리스트
    var tmp = -1
    for (i in processQueue.indices){
        if (result.isEmpty()){
            result.add(1)
            tmp = processQueue[i]
        }
        else if (tmp >= processQueue[i]){
            // 이전 작업 완료 시간보다 더 적게 걸리는 기능이면 같이 배포
            result[result.size-1] += 1
        }
        else{
            // 새로운 기능 배포 시점
            result.add(1)
            tmp = processQueue[i]
        }
    }
    println(result)

    return result
}
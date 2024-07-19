package heap.pgs_디스크컨트롤러

import java.util.PriorityQueue

fun main(){
    val jobs = arrayOf(
        intArrayOf(0, 3), intArrayOf(4, 4), intArrayOf(5, 3), intArrayOf(7, 1)
    )
    println(solution(jobs))
}

fun solution(jobs: Array<IntArray>): Int {
    if (jobs.isEmpty()) return 0

    // 작업을 요청 시간 오름차순으로 정렬
    val jobList = jobs.sortedBy { it[0] }.toMutableList()
    val priorityQueue = PriorityQueue<IntArray>(compareBy { it[1] })

    var currentTime = 0
    var totalWaitTime = 0
    var jobsProcessed = 0

    while (jobList.isNotEmpty() || priorityQueue.isNotEmpty()) {
        // 현재 시점에서 실행 가능한 작업들을 큐에 추가
        while (jobList.isNotEmpty() && jobList.first()[0] <= currentTime) {
            priorityQueue.offer(jobList.removeAt(0))
        }

        if (priorityQueue.isNotEmpty()) {
            // 실행할 작업을 큐에서 꺼냄
            val job = priorityQueue.poll()
            currentTime += job[1]
            totalWaitTime += currentTime - job[0]
            jobsProcessed++
        } else {
            // 실행 가능한 작업이 없으면 현재 시간을 증가시킴
            if (jobList.isNotEmpty()) {
                currentTime = jobList.first()[0]
            }
        }
    }

    return totalWaitTime / jobsProcessed
}

package heap.pgs_디스크컨트롤러

import java.util.PriorityQueue

fun main(){
    val jobs = arrayOf(
        intArrayOf(0, 3), intArrayOf(4, 4), intArrayOf(5, 3), intArrayOf(7, 1)
    )
    println(solution(jobs))
}

fun solution(jobs: Array<IntArray>): Int {
    // 작업을 요청되는 시점으로 오름차순 정렬 + 수정 가능한 mutalbleList로 형변환
    val jobList = jobs.sortedBy { it[0] }.toMutableList()

    // (작업이 요청되는 시점, 작업의 소요시간)의 IntArray의 배열을, 작업의 소요시간을 기준으로 빈 우선순위 큐 생성
    val priorityQueue = PriorityQueue<IntArray>(compareBy { it[1] })

    var currentTime = 0     // 현재 시간
    var totalWaitTime = 0   // 총 소요 시간
    var jobsProcessed = 0   // 처리된 작업의 수

    // jobList, priorityQueue가 비어 있을 때까지 계속 실행
    while (jobList.isNotEmpty() || priorityQueue.isNotEmpty()) {
        // 현재 시점에서 실행 가능한 작업들을 큐에 추가
        while (jobList.isNotEmpty() && jobList.first()[0] <= currentTime) { // jobList가 비어있으면 추가 하지 않는다.
            priorityQueue.offer(jobList.removeAt(0)) // jobList에서 제거한 후 추가; offer() == add()
        }

        if (priorityQueue.isNotEmpty()) {
            // 실행할 작업을 큐에서 꺼냄
            val job = priorityQueue.poll() // poll() : 가장 앞에 있는 노드를 return 후 삭제
            currentTime += job[1]
            totalWaitTime += currentTime - job[0]
            jobsProcessed++
        } else {
            // 실행 가능한 작업이 없으면 현재 시간을 증가시킴
            if (jobList.isNotEmpty()) {
                currentTime = jobList.first()[0] // jobList의 작업 요청시간이 가장 빠른 것으로
            }
        }
    }

    return totalWaitTime / jobsProcessed
}

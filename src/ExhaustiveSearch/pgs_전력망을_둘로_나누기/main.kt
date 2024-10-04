package ExhaustiveSearch.pgs_전력망을_둘로_나누기

import java.util.LinkedList
import java.util.Queue
import kotlin.math.abs
import kotlin.math.min


fun main(){
    val n = 9
    val wires = arrayOf(
        intArrayOf(1, 3),
        intArrayOf(3, 4),
        intArrayOf(4, 5),
        intArrayOf(4, 7),
        intArrayOf(4, 6),
        intArrayOf(7, 8),
        intArrayOf(7, 9),
        intArrayOf(2, 3),
    )
    println(solution(n, wires))
}

fun solution(n: Int, wires: Array<IntArray>): Int {
    // BFS를 사용하여 연결된 송전탑의 개수를 구하는 함수
    fun bfs(start: Int, graph: Array<MutableList<Int>>, visited: BooleanArray): Int {
        val queue: Queue<Int> = LinkedList()
        queue.offer(start)
        visited[start] = true
        var count = 1  // 시작 노드를 포함하므로 1로 시작

        println("BFS 시작 - 시작 노드: $start")
        println("큐 상태: ${queue.toList()}")

        while (queue.isNotEmpty()) {
            val node = queue.poll()
            println("큐에서 노드 $node 제거")
            println("큐 상태: ${queue.toList()}")

            for (neighbor in graph[node]) {
                if (!visited[neighbor]) {
                    visited[neighbor] = true
                    queue.offer(neighbor)
                    count++
                    println("  -> 노드 $neighbor 방문, 큐에 추가")
                    println("  -> 현재 큐 상태: ${queue.toList()}")
                }
            }
        }
        println("BFS 종료 - 컴포넌트 크기: $count")
        println()
        return count
    }

    var minDifference = n  // 차이의 최소값을 저장할 변수

    for (i in wires.indices) {
        // 그래프 구성
        val graph = Array(n + 1) { mutableListOf<Int>() }
        for (j in wires.indices) {
            if (i != j) {  // i번째 전선은 끊어짐
                val (v1, v2) = wires[j]
                graph[v1].add(v2)
                graph[v2].add(v1)
            }
        }

        // 그래프 상태 출력
        println("전선 $i 번째(${wires[i].contentToString()} 제거 후 그래프: ${graph.mapIndexed { idx, list -> "$idx: ${list.joinToString(", ")}" }}")

        // 하나의 전선을 끊었을 때 두 컴포넌트의 송전탑 개수 구하기
        val visited = BooleanArray(n + 1)
        val componentSize = bfs(1, graph, visited)  // 한 컴포넌트 크기 구하기
        val otherComponentSize = n - componentSize  // 다른 컴포넌트 크기

        // 두 컴포넌트 크기 차이의 절대값
        val difference = kotlin.math.abs(componentSize - otherComponentSize)

        // 각 시도마다 결과 출력
        println("전선을 끊은 후 컴포넌트 크기: $componentSize vs $otherComponentSize, 차이: $difference")

        // 최소 차이 갱신
        minDifference = kotlin.math.min(minDifference, difference)
        println()
    }

    return minDifference
}
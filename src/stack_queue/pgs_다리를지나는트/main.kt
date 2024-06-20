package stack_queue.pgs_다리를지나는트

fun main(){
    var bridge_length = 2
    var weight = 10
    var truck_weights = intArrayOf(
        7, 4, 5, 6
    )
    solution(bridge_length, weight, truck_weights)
}

fun solution(bridge_length: Int, weight: Int, truck_weights: IntArray): Int {
    var truck = truck_weights.toMutableList()
    var bridge = MutableList(bridge_length){ 0 } // 0으로 채워진 변경 가능한 리스트
    var count = 0
    while (truck.isNotEmpty()){
        count += 1

        if (bridge.any { it > 0 }){
            // 한 칸씩 이동
            bridge.add(0, 0)
            bridge.removeLast()
        }

        if (bridge.sum() + truck.first() <= weight){
            // 다리 건너기 시작
            bridge[0] = truck.removeFirst()
        }
    }

    return count + bridge_length
}
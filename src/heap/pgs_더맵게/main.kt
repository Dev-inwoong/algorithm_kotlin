package heap.pgs_더맵게

fun main(){
    var scoville = arrayListOf(
        1, 2, 3, 9, 10, 12
    )
    var K = 7
    println(solution(scoville, K))
}

fun solution(scoville : ArrayList<Int>, K : Int): Int {
    var count = 0

    while (scoville[0] < K){
        if (scoville.size < 2){
            return -1
        }
        scoville.sort()
        var old1 = scoville.removeFirst()
        var old2 = scoville.removeFirst()
        var new = old1 + old2 * 2
        scoville.add(new)
        count ++
    }
    println("count : $count, scoviles : $scoville")
    return count
}
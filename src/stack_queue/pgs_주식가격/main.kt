package stack_queue.pgs_주식가격

fun main(){
    var prices = intArrayOf(
        5, 4, 3, 2, 5
    )

    println(prices.toList())
    println(solution(prices).toList())
    println(intArrayOf(
        1, 1, 1, 1, 0
    ).toList())
}

fun solution(prices: IntArray): IntArray {
    val n = prices.size
    val answer = IntArray(n)
    val stack = ArrayDeque<Pair<Int, Int>>() // (가격, 인덱스)를 저장할 디큐

    for (i in prices.indices) {
        // 스택이 비어있지 않고, 스택의 가장 위의 가격이 현재 가격보다 크면
        while (stack.isNotEmpty() && stack.last().first > prices[i]) {
            val (p, idx) = stack.removeLast()
            answer[idx] = i - idx  // 가격이 떨어지는 지점까지 걸린 시간 저장
        }

        stack.addLast(prices[i] to i)  // 현재 가격과 인덱스를 스택에 저장
    }

    // 스택에 남아있는 가격들은 떨어지지 않은 것들이므로 남은 시간을 계산하여 저장
    while (stack.isNotEmpty()) {
        val (p, idx) = stack.removeLast()
        answer[idx] = n - idx - 1
    }

    return answer
}

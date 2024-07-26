package ExhaustiveSearch.pgs_모의고사

import kotlin.math.max

fun main(){
    val answers = intArrayOf(
        1, 3, 2, 4, 2
    )
    println(solution(answers).contentToString())
}

fun solution(answers: IntArray): IntArray {
    var answer = intArrayOf()
    // 1번 수포자의 답
    // -> 인덱스 % 5 + 1
    // 2번 수포자의 답
    // -> 짝수번째 인덱스 = 2, 홀수번째 인덱스 (1, 3, 4, 5) 반복
    // 3번 수포자의 답
    // -> (3, 3, 1, 1, 2, 2, 4, 4, 5, 5) 반복
    var score_1 = 0
    var score_2 = 0
    val rule_2 = intArrayOf(
        1, 3, 4, 5
    )
    var score_3 = 0
    val rule_3 = intArrayOf(
        3, 3, 1, 1, 2, 2, 4, 4, 5, 5
    )
    for (i in answers.indices) {
        var ans = answers[i]
        // case 1
        if (ans == i % 5 +1){
            score_1 ++
        }
        // case 2
        if (i % 2 == 0 && ans == 2){
            score_2 ++
        }else if (i % 2 != 0 && ans == rule_2[(i-1) / 2 % 4]){
            score_2 ++
        }
        // case 3
        if (ans == rule_3[i % 10]){
            score_3 ++
        }
    }

    val result = intArrayOf(
        score_1, score_2, score_3
    )

    val maximum = result.sorted().last()
    for (i in result.indices) {
        if (result[i] == maximum){
            answer += i+1
        }
    }

    return answer
}
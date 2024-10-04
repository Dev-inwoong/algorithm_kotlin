package ExhaustiveSearch.pgs_모음사전

fun main(){
    val word = "AAAAE"
    println(solution(word))
}

fun solution(word: String): Int {
    val vowels = listOf('A', 'E', 'I', 'O', 'U') // 모음 나열
    val weights = listOf(781, 156, 31, 6, 1) // 가중치 나열
    /*
        각 자리의 가중치
        weight[i] = 5 * weight[i-1] + 1 (각 자리의 가중치를 계산할 때 1을 더해주는 이유는 특정 자리의 문자 위치를 포함하기 위해서)
     */
    var result = 0 // 결과 저장

    for (i in word.indices){
        val n = vowels.indexOf(word[i]) // 순회하는 문자가 몇 번째 모음인지
        println("n = $n")
        result += n * weights[i] + 1 // 결과 변수에 현재 문자의 가중치를 더한다
        println("plus $n * ${weights[i]} + 1")
    }

    return result
}
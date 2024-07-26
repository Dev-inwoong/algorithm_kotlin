package ExhaustiveSearch.pgs_소수찾기

import kotlin.math.sqrt

fun main(){
    val numbers = "17"
    println(solution(numbers))
}

fun solution(numbers: String): Int {
    var answer = 0
    // 각 deep의 단계 별 결과 저장
    var permutationList = allPermutations(numbers.toList()).distinct()
    // 각 단계를 하나의 리스트로 저장
    var result = listOf<Int>()
    for (p in permutationList){
        val tmp = p.joinToString("").toInt()
        result += tmp
    }
    result = result.distinct()
    // 소수 판별
    for (r in result) {
        if (isPrime(r)){
            answer += 1
        }
    }
    return answer
}

// length 만큼의 길이를 가진 순열 리스트를 반환
fun <T> permutations(list: List<T>, length: Int): List<List<T>> {
    if (length == 0) return listOf(emptyList())

    val result = mutableListOf<List<T>>() // 결과 순열 리스트
    val used = BooleanArray(list.size) // 요소 사용 여부 추적
    val current = mutableListOf<T>() // 현재 순열 저장하는 리스트

    // 재귀적으로 순열 생성
    fun generate(depth: Int) {
        // 현재 깊이가 원하는 길이에 도달하면 현재 순열을 결과 리스트에 추가하고 종료
        if (depth == length) {
            println("complete : $current")
            result.add(ArrayList(current))
            return
        }
        // 모든 인덱스 순회
        for (i in list.indices) {
            // 이미 사용된 인덱스는 건너뛴다.
            if (used[i]) continue

            used[i] = true // 사용 처리
            current.add(list[i]) // 현재 순열에 추가
            generate(depth + 1) // 다음 깊이(순열 다음 자리) 작업 시작
            used[i] = false // 재귀 호출이 끝나 해당 인덱스를 사용하지 않음으로 표시
            println("before : $current")
            current.removeAt(current.size - 1) //
            println("after : $current")
        }
        println()
    }

    generate(0)
    return result
}
// 1부터 리스트 크기까지 모든 길이의 순열을 생성
fun <T> allPermutations(list: List<T>): List<List<T>> {
    val result = mutableListOf<List<T>>()   //결과를 저장할 리스트
    for (length in 1..list.size) {  // 1투너 리스트 크기까지 반복
        var permutation = permutations(list, length).distinct() // 특정 길이의 순열 리스트를 반환하고, 중복을 제거한다.
        result.addAll(permutation) // 결과를 저장한다.
    }
    return result
}

fun isPrime(n : Int): Boolean {
    if (n >= 2){
        for (i in 2 .. sqrt(n.toFloat()).toInt()){
            if (n % i == 0){
                return false
            }
        }
        return true
    }else{
        return false
    }
}

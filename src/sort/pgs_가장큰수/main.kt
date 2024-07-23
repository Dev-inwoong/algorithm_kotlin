package sort.pgs_가장큰수


fun main(){
    val numbers = intArrayOf(
        0, 0, 0
    )
    println(solution(numbers))
}

fun solution(numbers: IntArray): String {
    var answer = ""
    // 숫자를 문자열로 변환
    val strings = numbers.map { it.toString() }
    // 문자열 정렬 기준 정의: (x + y)와 (y + x)를 비교하여 큰 쪽을 선택
    val sortedStrings = strings.sortedWith { x, y ->
        (y + x).compareTo(x + y)
    }
    answer = if (sortedStrings.first() == "0"){
        "0"
    }else{
        sortedStrings.joinToString("")
    }
    return answer
}
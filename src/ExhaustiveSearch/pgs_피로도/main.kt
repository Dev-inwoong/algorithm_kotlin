package ExhaustiveSearch.pgs_피로도

fun main(){
    val k = 80
    val dungeons = arrayOf(
        intArrayOf(80, 20),
        intArrayOf(50, 40),
        intArrayOf(30, 10)
    )

    println(solution(k, dungeons))
}

fun solution(k: Int, dungeons: Array<IntArray>): Int {
    // 최대 탐험 가능한 던전 수를 저장할 변수
    var maxDungeonCount = 0

    // 모든 순열을 탐색하는 함수
    fun explore(currentFatigue: Int, exploredCount: Int, remainingDungeons: List<IntArray>) {
        // 최대 던전 수 갱신
        maxDungeonCount = maxOf(maxDungeonCount, exploredCount)

        for (i in remainingDungeons.indices) { // 남은 던전 수를 0부터
            val (requiredFatigue, consumedFatigue) = remainingDungeons[i] // 필요 피로도, 소모 피로
            if (currentFatigue >= requiredFatigue) { // 현재 남은 피로도가 요구 피로도보다 크거나 같으면(탐험 할 수 있으면)
                // 현재 던전을 탐험한 후 남은 던전들로 다시 탐색
                explore(
                    currentFatigue - consumedFatigue,  // 남은 피로도는 현재 남은 피로도에서 소모 피로도를 뺀 값
                    exploredCount + 1, // 탐험 횟수 1증가
                    remainingDungeons.filterIndexed { index, _ -> index != i } // 남은 던전 리스트는 기존 리스트에서 현제 인덱스의 던전을 뺀 리스트
                )
            }
            // 현재 남은 피로도로 탐험할 수 있는 던전이 없으면 함수의 실행이 끝나게 된다.
        }
    }

    // 모든 던전을 초기 피로도 k로 탐색 시작
    explore(k, 0, dungeons.toList())

    return maxDungeonCount
}
package sort.pgs_K번째수

fun main(){
    val array = intArrayOf(
        1, 5, 2, 6, 3, 7, 4
    )
    val commands = arrayOf(
        intArrayOf(2, 5, 3), intArrayOf(4, 4, 1), intArrayOf(1, 7, 3)
    )
    println(solution(array, commands).contentToString())
}

fun solution(array: IntArray, commands: Array<IntArray>): IntArray {
    var answer = intArrayOf()

    commands.forEach {
        var newArray = array.slice(it[0]-1..it[1]-1)
        newArray = newArray.sorted()
        val k = newArray[it[2]-1]
        answer += k
    }

    return answer
}
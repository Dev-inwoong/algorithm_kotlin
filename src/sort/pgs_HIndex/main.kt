package sort.pgs_HIndex

fun main(){
    val citations = intArrayOf(
        9,9,9,9,9
    )
    println(solution(citations))
}

fun solution(citations: IntArray): Int {
    citations.sortDescending()
    println(citations.contentToString())
    for (i in citations.indices) {
        if (citations[i] <= i){
            println("${citations[i]} $i")
            return i
        }
    }

    return citations.size
}
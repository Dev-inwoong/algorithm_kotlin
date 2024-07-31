package ExhaustiveSearch.pgs_카펫

import kotlin.math.max
import kotlin.math.min
import kotlin.math.sqrt

fun main(){
    val brown = 24
    val yellow = 24
    println(solution(brown, yellow).contentToString())
}

fun solution(brown: Int, yellow: Int): IntArray {
    var answer = intArrayOf()

    var yaksu = mutableListOf<Int>()
    for (i in 1 .. sqrt(yellow.toFloat()).toInt()) {
        if (yellow % i == 0){
            yaksu.add(i)
            yaksu.add(yellow / i)
        }
    }
    while (yaksu.size != 0){
        var fst = yaksu.removeFirst()
        var scd = 0
        if (yaksu.size == 0){
            scd = fst
        }else{
            scd = yaksu.removeFirst()
        }
        var width = max(fst, scd)
        var height = min(fst, scd)
        var widthB = width + 2
        var heightB = height + 2

        if (widthB * heightB == brown + yellow){
            answer+= widthB
            answer+= heightB
            break
        }
    }

    return answer
}
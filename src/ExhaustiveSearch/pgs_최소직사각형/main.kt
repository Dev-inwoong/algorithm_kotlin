package ExhaustiveSearch.pgs_최소직사각형

import kotlin.math.max

fun main(){
    val sizes = arrayOf(
        intArrayOf(14, 4),
        intArrayOf(19, 6),
        intArrayOf(6, 16),
        intArrayOf(18, 7),
        intArrayOf(7, 11),
    )
    println(solution(sizes))
}

fun solution(sizes: Array<IntArray>): Int {
    var max_length = 0
    var other = 0

    for (size in sizes) {
        println("$max_length $other")
        println(size.contentToString())

        val w = size.first()
        val h = size.last()
        if (w > h){
            if (w > max_length){
                max_length = w
                if (h > other){
                    other = h
                }
            }else{
                if (h > other){
                    other = h
                }
            }
        }else{
            if (h > max_length){
                max_length = h
                if (w > other){
                    other = w
                }
            }else{
                if (w > other){
                    other = w
                }
            }
        }
        println("-> $max_length $other")
        println()
    }


    return max_length * other
}
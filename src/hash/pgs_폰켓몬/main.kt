package hash.pgs_폰켓몬

fun main(){
    var nums = intArrayOf(3, 3, 3, 2, 2, 2)
    print(solution(nums))
}

fun solution(nums: IntArray): Int {
    var selection = nums.size / 2
    var n = nums.toSet().size
    if(n < selection){
        return n
    }else{
        return selection
    }
}
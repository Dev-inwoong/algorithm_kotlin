package stack_queue.pgs_올바른괄호

fun main(){
    var s = "(()("
    println(solution(s))
}

fun solution(s : String): Boolean {
    var queue = ArrayList<Char>()
    var check = arrayListOf(
        '(', ')'
    )
    for(sig in s){
        if (queue.isEmpty()){
            if (sig == ')'){
                return false
            }else{
                queue.add(sig)
            }
        }else if (queue.size < 2){
            queue.add(sig)
        }else{
            queue.add(sig)
            if (queue.takeLast(2) == check){
                queue.removeLast()
                queue.removeLast()
            }
        }
    }

    if (queue.takeLast(2) == check){
        queue.removeLast()
        queue.removeLast()
    }

    if (queue.isEmpty()){
        return true
    }else{
        return false
    }
}
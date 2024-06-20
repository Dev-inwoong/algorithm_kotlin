package hash.pgs_완주하지_못한_선수

fun main(){
    var participant = arrayListOf(
        "marina", "josipa", "nikola", "vinko", "filipa"
    )
    var completion = arrayListOf(
        "josipa", "filipa", "marina", "nikola"
    )
    print(solution(participant, completion))
}

fun solution(participant : ArrayList<String>, completion : ArrayList<String>): ArrayList<String> {
    for(c in completion){
        participant.remove(c)
    }
    return participant
}
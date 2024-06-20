package hash.pgs_베스트앨범

fun main(){
    var genres = arrayOf(
        "classic", "pop", "classic", "classic", "pop"
    )
    var plays = intArrayOf(
        500, 600, 150, 800, 2500
    )
    print(solution(genres, plays))
}

fun solution(genres: Array<String>, plays: IntArray): IntArray {
    // 장르별 총 재생 횟수를 저장할 맵
    val totalPlayMap = mutableMapOf<String, Int>()
    // 각 장르별 노래들의 정보를 저장할 맵
    val songMap = mutableMapOf<String, MutableList<Pair<Int, Int>>>()

    // 데이터 초기화
    for (i in genres.indices) {
        val genre = genres[i]
        val play = plays[i]

        // 총 재생 횟수 업데이트
        totalPlayMap[genre] = totalPlayMap.getOrDefault(genre, 0) + play

        // 장르별 노래 정보 업데이트
        if (!songMap.containsKey(genre)) {
            songMap[genre] = mutableListOf()
        }
        songMap[genre]!!.add(Pair(i, play))
    }

    // 총 재생 횟수가 많은 장르부터 정렬
    val sortedGenres = totalPlayMap.toList().sortedByDescending { it.second }.toMap()
    println(songMap)
    println(sortedGenres)
    // 결과를 저장할 리스트
    val result = mutableListOf<Int>()

    // 장르별로 최대 2개씩 노래 선택
    for ((genre, _) in sortedGenres) {
        val songs = songMap[genre]!!.sortedWith(compareBy({ -it.second }, { it.first }))
        val selectedSongs = songs.take(2).map { it.first }
        result.addAll(selectedSongs)
    }

    return result.toIntArray()
}
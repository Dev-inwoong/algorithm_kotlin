package pgs_전화번호_목록

fun main(){
    var phone_book = arrayOf(
        "12", "123", "1235", "567", "88"
    )
    print(solution(phone_book))
}

fun solution(phone_book: Array<String>): Boolean {
    // 전화번호 목록을 정렬합니다.
    phone_book.sort()
    // # 정렬된 전화번호 목록을 순회하면서 현재 번호가 다음 번호의 접두어인지 확인합니다.
    for(i in phone_book.indices){
        if(phone_book[i+1].startsWith(phone_book[i])){
            return false
        }
    }
    // 접두어 관계가 없으면 True를 반환합니다.
    return true
}
package hash.pgs_의상

fun main(){
    var clothes = arrayListOf(
        arrayListOf("yellow_hat", "headgear"),
        arrayListOf("blue_sunglasses", "eyewear"),
        arrayListOf("green_turban", "headgear"),
    )
    print(solution(clothes))
}

fun solution(clothes : ArrayList<ArrayList<String>>): Int {
    var clothesMap = HashMap<String, ArrayList<String>>()
    for (c in clothes){
        var type = c[1]
        if (clothesMap[type] == null){
            clothesMap[c[1]] = arrayListOf(c[0])
        }else{
            clothesMap[c[1]]!!.add(c[0])
        }
    }
    // a + b + c + ... ab + ac + bc + ... + abc..n
    // -> (a+1)(b+1)(c+1)....(n+1)-1
     var num = 1
    for (value in clothesMap.values){
        num *= value.size + 1
    }
    return num-1
}
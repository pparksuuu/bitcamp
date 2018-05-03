// 메서드 - 파라미터 II
package ex3

printMap = {m ->
    for (e in m) {
        println e.key + "=" + e.value
    }
}

myMap = ["홍길동":20, "임꺽정":30, "유관순":16]

printMap(myMap)
println "----------------------"

printMap(["홍길동":20, "임꺽정":30, "유관순":16])
println "----------------------"

// 메서드를 호출할 때 괄호를 치지 않고 맵 객체를 넘길 때는
// 맵의 대괄호 []도 생략해야 한다.
printMap "홍길동":20, "임꺽정":30, "유관순":16
println "----------------------"

// key를 
printMap 홍길동:20, 임꺽정:30, 유관순:16
println "----------------------"
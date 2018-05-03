// 메서드 - closure 파라미터와 it 배열
package ex3

plus = {a, b ->
    a + b
}

sum = plus(100,200)
println sum

sum = plus 101, 201
println sum
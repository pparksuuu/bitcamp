// 예외 처리 문법을 적용하기 전 - 리턴 값으로 오류 여부를 알려준다. 
package step21.ex01;

public class Calculator2 {
    public static int compute(String op, int a, int b) {
        switch (op)  {
        case "+": return a + b;
        case "-": return a - b;
        case "*": return a * b;
        case "/": return a / b;
        case "%": return a % b;
        default: 
            // 만약 유효한 연산자기 아닐 경우 계산 결과는?
            return -1212121212;
        }
    }
}

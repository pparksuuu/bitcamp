// 예외 처리 문법을 적용하기 전
package step21.ex01;

public class Exam01_3 {
    public static void main(String[] args) {
        // 유효한 값을 지정하여 메서드를 호출할 때, 
        int result = Calculator2.compute("#", 100, 200);

        // 제대로 계산을 수행했는지 검사하기 위해 보통 리턴 값을 검사.
        if (result == -1212121212) {
            System.out.println("유효하지 않은 연산자입니다.!");
        } else {
            System.out.println(result);
        }
        
        // 리턴 값을 검사하는 방식의 문제는 다음과 같이 정상적인 계산 결과도
        // 잘못된 계산으로 취급한다는 점이다. 
        result = Calculator.compute("-", 6, 7);
        
        // 위의 계산 결과는 정상적인 값이다.
        // 그런데도 불구하고 다음과 같이 -1을 리턴하는 경우 오류로 간주
        if (result == -1212121212) {
            System.out.println("유효하지 않은 연산자입니다.!");
        } else {
            System.out.println(result);
        }
        
        // 아무리 희귀한 값을 리턴한다 하더라도 결국에는 그 희귀한 값 또한
        // 정상 값일 수 있다. 이것은 해결핼 수 없다.
        result =Calculator.compute("+", -2078654356, 866533144 );
        
        if (result == -1212121212) {
            System.out.println("유효하지 않은 연산자입니다.!");
        } else {
            System.out.println(result);
        }
                
    }
}

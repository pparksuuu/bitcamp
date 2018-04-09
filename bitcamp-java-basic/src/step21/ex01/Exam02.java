// 예외 처리 문법을 적용하기 전
package step21.ex01;

public class Exam02 {
    public static void main(String[] args) {
        // 유효한 값을 지정하여 메서드를 호출할 때, 
        int result = Calculator.compute("#", 100, 200);

        // 제대로 계산을 수행했는지 검사하기 위해 보통 리턴 값을 검사.
        if (result == -1) {
            System.out.println("유효하지 않은 연산자입니다.!");
        } else {
            System.out.println(result);
        }
        
        // 리턴 값을 검사하는 방식의 문제는 다음과 같이 정상적인 계산 결과도
        // 잘못된 계산으로 취급한다는 점이다. 
    }
}

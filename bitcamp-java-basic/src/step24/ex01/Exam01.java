// 멀티 스레드 적용 전
package step24.ex01;

public class Exam01 {
    public static void main(String[] args) {
        //코드는 위에서 아래로 순서대로 실행한다.
        for (int i = 0; i < 1000; i++) {
            System.out.println("==> " + i);
        }
        
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>> " + i);
        }
    }
}

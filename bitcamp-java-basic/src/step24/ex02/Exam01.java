// 현재의 실행 라인을 알아내기
package step24.ex02;

public class Exam01 {
    public static void main(String[] args) {
        // 이 순간 실행중인 흐름이 무엇인지 알고 싶다면?
        Thread t = Thread.currentThread();
        System.out.println("실행 흐름명 = " + t.getName());
        
        // 실행 흐름을 
    }
}

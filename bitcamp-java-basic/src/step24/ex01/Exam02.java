// 멀티 스레드 적용 전
package step24.ex01;

public class Exam02 {
    
    static class MyThread extends Thread {
        @Override
        public void run() {
            for (int i = 0; i < 1000; i++) {
                System.out.println(">>> " + i);
            }
        }
    }
    
    public static void main(String[] args) {
        new MyThread().start();
        
        //코드 실행 라인을 새로 만들어 따로 실행한다.
        for (int i = 0; i < 1000; i++) {
            System.out.println("==> " + i);
        }
    }
}

// 자바는 main() 메서드를 실행하는 한 개의 실행 흐름이 있다.
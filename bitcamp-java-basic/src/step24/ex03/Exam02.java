// Runnable 인터페이스 구현 + Thread
package step24.ex03;

public class Exam02 {
    public static void main(String[] args) {
        class MyRunnable implements Runnable {
            
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> " + i);
                }
            }
        }
        
        Thread t = new Thread(new MyRunnable());
        t.start(); 
        
        // "main" 스레드는 MyThread와 상관없이 병행하여 실행한다.
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>> " + i);
        }
    }
}

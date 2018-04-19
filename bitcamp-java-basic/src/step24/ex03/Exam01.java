package step24.ex03;

public class Exam01 {
    public static void main(String[] args) {
        class MyThread extends Thread {
            
            @Override
            public void run() {
                for (int i = 0; i < 1000; i++) {
                    System.out.println("===> " + i);
                }
            }
        }
        
        MyThread t = new MyThread();
        t.start(); 
        
        // "main" 스레드는 MyThread와 상관없이 병행하여 실행한다.
        for (int i = 0; i < 1000; i++) {
            System.out.println(">>> " + i);
        }
            
    }
}

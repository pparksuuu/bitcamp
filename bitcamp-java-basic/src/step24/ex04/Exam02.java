// 스레드의 생명주기(lifecycle) 
package step24.ex04;

public class Exam02 {
    public static void main(String[] args) throws Exception{

        System.out.println("스레드 실행 전");

        Thread t = new Thread() {
            public void run() {
                for (int i =0; i <1000; i++) {
                    System.out.println("===> " + i);

                }
            }
        };
        
        t.start();
        
        t.join(); // t 스레드가 종료될 때까지 "main" 스레드는 기다린다.
        
        // 즉 t스레드가 종료된 후 다음 코드를 실행한다.
        System.out.println("스레드 실행 후");
        
        t.start();
    }
}

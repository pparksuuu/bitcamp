// 스레드의 생명주기(lifecycle) - 우선 순위 조회 및 설정
package step24.ex04;

public class Exam06 {
    public static void main(String[] args) throws Exception{

        class MyThread extends Thread {
            public MyThread(String name) {
                super(name);
            }

            public void run() {
                long startTime = System.currentTimeMillis();
                for (int i = 0; i < 1000000000; i++) 
                    Math.asin(38.567);
                long endTime = System.currentTimeMillis();
                System.out.printf("MyThread = %d\n" ,endTime - startTime);
            }
        }

        MyThread t1 = new MyThread("t1");
        t1.setPriority(10);
        
        
        System.out.printf("main 스레드 우선 순위: %d\n",
                Thread.currentThread().getPriority());
        
        System.out.printf("%s 스레드 우선 순위: %d\n",
                t1.getName(), t1.getPriority());
        
        // t1 스레드 작업 시작
        t1.start();
        
        // main작업 시작
        long startTime = System.currentTimeMillis();
        for (int i = 0; i < 1000000000; i++) 
            Math.asin(38.567);
        long endTime = System.currentTimeMillis();
        System.out.printf("main = %d\n" ,endTime - startTime);
    }
}

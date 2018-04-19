// 스레드의 생명주기(lifecycle) - running 상태 - CPU 쟁탈전(racing)
package step24.ex04;

public class Exam04 {
    public static void main(String[] args) throws Exception{

        class MyThread extends Thread {
            public MyThread(String name) {
                super(name);
            }

            public void run() {
                for (int i = 0; i < 1000; i++)
                    System.out.printf("%s %d\n", this.getName(), i);
            }
        }

        MyThread t1 = new MyThread("홍길동===> ");
        MyThread t2 = new MyThread("오호라----------> ");
        MyThread t3 = new MyThread("우헤헤 ##");

        // 스레드를 시작시키는 순간 running 상태로 접어든다.
        t1.start();
        t2.start();
        t3.start();
        
        for (int i = 0; i < 1000; i++)
            System.out.printf("main스레드 : %d\n", i);

        System.out.println("스레드 실행 후");
    }
}

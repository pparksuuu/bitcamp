// 스레드 그룹의 부모 그룹
package step24.ex02;

public class Exam07 {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();
        ThreadGroup systemGroup = mainGroup.getParent();

        Thread[] arr = new Thread[100];
        int count = systemGroup.enumerate(arr, true);
        
        System.out.println("system 스레드 그룹에 소속된 스레드들: ");
        for (int i = 0; i < count; i++) {
            System.out.println("    => " + arr[i].getName());
        }
    }
}

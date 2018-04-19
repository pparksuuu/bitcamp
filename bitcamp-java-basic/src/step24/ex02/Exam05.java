// 스레드 그룹의 부모 그룹
package step24.ex02;

public class Exam05 {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();

        ThreadGroup parentGroup = mainGroup.getParent();
        System.out.println(parentGroup.getName());

        ThreadGroup grandparentGroupd = parentGroup.getParent();
        if (grandparentGroupd != null) {
            System.out.println(grandparentGroupd.getName());
        }
    }
}

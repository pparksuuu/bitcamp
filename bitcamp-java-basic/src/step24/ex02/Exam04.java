// 스레드 그룹
package step24.ex02;

public class Exam04 {
    public static void main(String[] args) {
        Thread main = Thread.currentThread();
        ThreadGroup mainGroup = main.getThreadGroup();

        ThreadGroup[] groups = new ThreadGroup[100];
        int count = mainGroup.enumerate(groups, false);
        // 두 번째 파라미터 값을 false로 지정하면, 
        // 하위 그룹에 소속된 그룹들 제외한다.
        // => 즉, 현재 그룹에 소속된 스레드 목록만 가져오라는 뜻!

        System.out.println("main 그룹에 소속된 스레드들: ");
        for (int i = 0; i < count; i++) {
            System.out.println("     => " + groups[i].getName());
        }

    }
}

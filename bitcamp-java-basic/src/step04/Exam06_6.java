// 증감 연산자 : 전위(pre-fix) 감소 연산자
package step04;

public class Exam06_6 {
    public static void main(String[] args) {
        int i = 7;
     
        --i;
        //1) i 메모리의 값을 먼저 증가시킨다.
        //2) 그리고 i 메모리의 값을 그 자리에 놓는다.

        --i;

        System.out.println(i);

        System.out.println(--i);

        System.out.println(i);
        
        
    }
}
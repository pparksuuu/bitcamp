// 산술 연산자 : 우선 순위
package step04;

public class Exam01_2 {
    public static void main(String[] args) {
        //*, /, %는  +, - 보다 먼저 계산.
        System.out.println(2 + 3 * 7);
        System.out.println(3 * 7 + 2);

        //같은 우선순위에서는 먼저 나온 것을 먼저 계산.
        System.out.println(3 * 8 / 2);
        System.out.println(8 / 2 * 3);
        
    }
}
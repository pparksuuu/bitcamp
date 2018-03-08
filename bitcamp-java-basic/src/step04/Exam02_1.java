// 관계 연산자 : <, <=, >, >=, ==, !=
package step04;

public class Exam02_1 {
    public static void main(String[] args) {
        int a = 10;
        int b = 20;
        boolean r1 = a < b; //true
        //int r2 = a < b; //컴파일 오류! (JAVA).
        //C에서는 비교 연산자의 리턴 타입이 1 또는 0.(boolean type이 없다)
        
        System.out.println(a < b);
        System.out.println(a <= b);
        System.out.println(a > b);
        System.out.println(a >= b);
        System.out.println(a == b);
        System.out.println(a != b);


    }
}




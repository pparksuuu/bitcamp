//논리 연산자 : &&, ||, !(not), ^(XOR)
package step04;

public class Exam03_1 {
    public static void main(String[] args) {
        //AND 연산자
        // - 두 개의 논리 값이 모두 true일 때 true
        System.out.println(true && true);
        System.out.println(true && false);
        System.out.println(false && true);
        System.out.println(false && false);

        System.out.println("============");

        //OR 연산자
        // - 두 개의 논리 값 중 한 개라도 true이면 true
        System.out.println(true || true);
        System.out.println(true || false);
        System.out.println(false || true);
        System.out.println(false || false);

        System.out.println("============");
        
        //NOT 연산자
        // true -> false로 , flase -> true로.
        System.out.println(!true);
        System.out.println(!false);

        System.out.println("============");
        
        //exclusive-OR(XOR) 연산자
        // 배타적 비교 연산자
        // 두 개의 값이 다를 때 true
        System.out.println(true ^ true);
        System.out.println(false ^ true);
        System.out.println(false ^ false);
        
    }
}




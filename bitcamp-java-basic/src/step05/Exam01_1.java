//흐름 제어문 - 조건문 if
package step05;

public class Exam01_1 {
    public static void main(String[] args) {
        int age = 17;

        // => if (조건) 문장;
        if (age >= 19) System.out.println("성인이다");

        // => 문자를 다른 줄에 놓는 경우가 많다.
        if (age >= 19); //if 문에 빈 문장을 넣을 수 있다.
            System.out.println("성인이다.");
        //세미콜론 주의 !

        
        
    }
}
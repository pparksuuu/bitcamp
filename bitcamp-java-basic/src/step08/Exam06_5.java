// 초기화 블록 - 클래스 블록 = static 블록 의 목적
package step08;

public class Exam06_5 {
    public static class A {
        static float pi;
        static float area(int r) {
            return 2 * pi * r;
        }

        //스태틱 블록은 클래스 멤버를 사용하기 전에 유요한 값으로 초기화시키는 것.
        
        static {
            pi = 3.14159f;
        }
       
    }
    public static void main(String[] args) throws Exception { 
        System.out.println(A.area(25));
    }
}

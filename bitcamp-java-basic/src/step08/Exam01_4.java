//클래스 변수
package step08;

public class Exam01_4 {

    static class A {
        //클래스 변수 = 스태틱 변수
        // => 클래스를 로딩하는 순간 자동 생성된다
        // => 클래스 이름으로 사용한다고 해서 "클래스에 소속된 변수"
        // => static이 붙은 변수이기 때문에 "스태틱 변수"라고 한다.
        // => 클래스와 함께 "Method Area"영역에 존재한다.
        static int v1;
        static boolean v2;
        //이 명령은 new 명령을 실행할 때 비로서 실행된다.
    }
    public static void main(String[] args) {
        A.v1 = 100;
        A.v2 = true;
        
        System.out.printf("%d, %b\n", A.v1, A.v2);
    }

}

//

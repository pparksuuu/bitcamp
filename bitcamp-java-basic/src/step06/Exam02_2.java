//메서드 : 개념 및 기본 문법
package step06;

import java.util.Scanner;
public class Exam02_2 {

    // 2) 함수1 : 리턴값(x), 파라미터(o)
    static void hello(String name, int age) {
        System.out.printf("%d살 %s님 반갑습니다\n", age, name);
    }

    public static void main(String[] args) {
        //=> 메서드 호출하기!!
        System.out.println("main()1111");

        hello("홍길동", 20);

        System.out.println("main()2222");
        
        hello("임꺽정", 30);

        System.out.println("main()3333");
        
        hello("유관순", 16);

        System.out.println("main()4444");
        
        //파라미터의 타입, 개수, 순서가 일치해야 한다.
        //hello("윤봉길"); //컴파일 오류
        //hello(20, "윤봉길"); //컴파일 오류
        //String r = hello("안중근", 30); //컴파일 오류
        //void r = hello("안중근", 30); //컴파일 오류
        
        
    }
}


//아규먼트(argument)
// => 메서드를 호출할 때 넘겨주는 값
// => 예) hello("홍길동", 20);
//    "홍길동", 20이 아규먼트이다
//
//파라미터(parameter)
// => 아규먼트를 받는 변수
// => 예) void hello(String name, int age) {...}
// name과 age 변수가 파라미터이다.
//
//현장에서는 "아규먼트"와 "파라미터"를 구분하지 않고 사용한다.
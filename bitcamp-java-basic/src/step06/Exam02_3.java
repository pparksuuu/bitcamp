//메서드 : 개념 및 기본 문법 III
package step06;

import java.util.Scanner;
public class Exam02_3 {

    // 3) 메서드 : 리턴값(o), 파라미터(x)
    // 메서드를 종료하기 전에 반드시 그 타입의 값을 리턴해야 한다.
    // 리턴 타입은 반드시 한 개만 가능하다.
    // 여러 개의 값을 리턴하고 싶다면, 배열에 담거나 객체에 담아 리턴하라!

    static String hello() {
        return "안녕하세요!";
    }

    public static void main(String[] args) {

        String r = hello();
        System.out.println(r);

        hello(); //이때 값을 받을 변수가 없기 때문에 리턴 값은 버려진다.

        //int r2 = hello(); //컴파일 오류!
    }
}


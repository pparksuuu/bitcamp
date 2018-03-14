//메서드 : 개념 및 기본 문법 IV
package step06;

import java.util.Scanner;
public class Exam02_4 {

    // 4) 메서드 : 리턴값(o), 파라미터(o)

    static String hello(String name, int age) {
        String retVal = String.format("%d살 %s님을 환영합니다!", age, name);        
        return retVal; //(물론 실무에선 바로 넣겠지)
    }

    public static void main(String[] args) {

        String r = hello("홍길동", 20);
        System.out.println(r);

        //리턴값을 안 받아도 된다.
        hello("임꺽정", 30); //리턴 값은 버려진다

    }
}


//흐름 제어문 - if ~ else 문
package step05;

import javax.lang.model.util.ElementScanner6;

public class Exam01_4 {
    public static void main(String[] args) {
        int age = 17;

        //if문은 else문 없이 단독으로 사용할 수 있다.
        if(age < 19) 
            System.out.println("미성년입니다.");

        //else문을 사용하는 아주 모범적인 예!
        if (age >= 19) 
            System.out.println("성입입니다.");
        else
            System.out.println("미성년입니다.");

        // //잘못 사용한 예:
        // // => else 문만 단독으로 사용할 수 없다.
        // else 
        //     System.out.println("컴파일 오류");

        // => if 문과 else문 사이에 다른 문장이 올 수 없다.

        // if (age >= 19) 
        //     System.out.println("성입입니다.");
        // System.out.println("==================");
        // else
        //     System.out.println("미성년입니다.");

        //블록 -> if문에 소속
        if(age >= 19) { //OK!
            System.out.println("성인입니다");
            System.out.println("=====================");
        }
        else
            System.out.println("미성년입니다.");

    }
}
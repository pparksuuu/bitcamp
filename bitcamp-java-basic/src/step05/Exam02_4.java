//흐름 제어문 - switch 문법 II
package step05;

import java.util.Scanner;

public class Exam02_4 {
    public static void main(String[] args) {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("사용자 레벨? ");
        int level = keyScan.nextInt();

        //상수를 사용할 때
        // => 값의 의미를 주석으로 달아야만 다른 개발자가 이해할 수 있다.
        switch (level) {
        case 0: //손님
            System.out.println("조회만 가능합니다.");
            break;
        case 1: //일반 회원
            System.out.println("글작성 가능합니다.");
            break; 
        case 2: //관리자
            System.out.println("다른 회원의 글을 변경, 삭제할 수 있습니다.");
            break;
        }

        //상수를 사용하면 주석업이 바로 이해할 수 있다.
        final int GUEST = 0, MEMBER = 1, ADMIN = 2;
        switch (level) {
        case GUEST: //손님
            System.out.println("조회만 가능합니다.");
            break;
        case MEMBER: //일반 회원
            System.out.println("글작성 가능합니다.");
            break; 
        case ADMIN: //관리자
            System.out.println("다른 회원의 글을 변경, 삭제할 수 있습니다.");
            break;
        }
    }
}
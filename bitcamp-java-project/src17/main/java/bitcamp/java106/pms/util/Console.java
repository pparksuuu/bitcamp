// 이 클래스는 명령창에서 사용할 기능을 모아 둔 클래스이다.
package bitcamp.java106.pms.util;

import java.util.Scanner;

public class Console {
    // 이 클래스를 사용하기 전에 반드시 Scanner 객체를 설정하라!
    public static Scanner keyScan;

    public static boolean confirm(String message) {
        System.out.printf("%s (y/N)", message);
        String input = keyScan.nextLine().toLowerCase();
        if (input.equals("y")) 
            return true;
        else
            return false;
    }

    public static String[] prompt() {
        System.out.print("명령> ");
        return keyScan.nextLine().toLowerCase().split(" ");
    }
}

// ver 16 
// Console 클래스 문제점
// - Console을 사용하려면 반드시 Scanner 객체가 필요하다.
// - 그러나 스태틱 변수를 강제적으로 설정하게 하는 방법은 현재로서는 없다.
//
// 이 프로젝트에서 Console을 유지보수하기 쉽게 만들기
// 1)Scanner 객체를 강제로 설정하게 만드는 방법?
//   =>생성자를 도입하라!
// 2)Console 객체를 한 개만 생성하게 만드는 방법?
//   => singleton 설계 패턴으로 Console 클래스를 변경하라!
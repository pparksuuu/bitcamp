package bitcamp.java106.pms; //java가 root folder이기 때문임.

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.controller.TeamController;
import bitcamp.java106.pms.controller.MemberController;
import bitcamp.java106.pms.util.Console;

import java.util.Scanner;

// ver 0.1 - team 메뉴를 처리하는 코드를 team controller를 처리하는 코드로 바꾼다.
public class App {
    // 클래스 변수 = 스태틱 변수
    // => 클래스 안 어디에서나 사용할 수 있는 변수.
    static Scanner keyScan = new Scanner(System.in);
    
    //클래스 변수는 이 클래스의 모든 메서드에서 사용할 수 있다.

    static String option = null; 

   
    static void onQuit() {
        System.out.println("안녕히 가세요!");
    }

    static void onHelp() {
        System.out.println("[도움말]");
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("종료 : quit");
    }

    public static void main(String[] args) {
        //클래스를 사용하기 전에 필수 값을 설정한다.
        TeamController.keyScan = keyScan;
        MemberController.keyScan = keyScan;
        Console.keyScan = keyScan;
        while (true) {
            String[] arr = Console.prompt();

            String menu = arr[0];
            if (arr.length == 2) {
                option = arr[1];
            } else {
                option = null;
            }

            if (menu.equals("quit")) {
                onQuit();
                break;
            } else if (menu.equals("help")) {
                onHelp();
            } else if (menu.startsWith("team/")) { 
                //team으로 시작하는 명령어는 아래에 넘겨줘
                TeamController.service(menu, option);
            } else if (menu.startsWith("member/")) {
                MemberController.service(menu, option);
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }
            System.out.println();
        }

    }
}
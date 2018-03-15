package bitcamp.java106.pms; //java가 root folder이기 때문임.

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.controller.TeamController;
import bitcamp.java106.pms.util.Console;
import java.util.Scanner;

//ver 0.1 - 팀 관리 기능(메서드)를 별도 클래스로 옮긴다.
//          =>
public class App {
    // 클래스 변수 = 스태틱 변수
    // => 클래스 안 어디에서나 사용할 수 있는 변수.
    static Scanner keyScan = new Scanner(System.in);
    
    //클래스 변수는 이 클래스의 모든 메서드에서 사용할 수 있다.

    static String option = null; 
    static Member[] members = new Member[1000];
    static int memberIndex = 0;


 

    static int getMemberIndex(String id) {
        for (int i = 0; i < memberIndex; i++) {
            if(members[i] == null) continue;            
            if (id.equals(members[i].id.toLowerCase())) {
                return i;
            }
        }
        return -1;
    }

  
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
    
  
    static void onMemberAdd() {
        System.out.println("[회원 정보입력]");
        Member member = new Member();

        System.out.print("아이디? ");
        member.id = keyScan.nextLine();

        System.out.print("이메일? ");
        member.email = keyScan.nextLine();

        System.out.print("암호? ");
        member.password = keyScan.nextLine();

        members[memberIndex++] = member;
    }

    static void onMemberList() {
        System.out.println("[회원 목록]");
        for (int i = 0; i < memberIndex; i ++) {
            if(members[i] == null) continue;            
            System.out.printf("%s, %s, %s\n",
            members[i].id, members[i].email, 
            members[i].password);  
        }

    }

    static void onMemberView() {
        System.out.println("[회원 정보 조회]");
        if (option == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            System.out.println();
            return;
        }

        int i = getMemberIndex(option);

        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member member = members[i];
            System.out.printf("아이디: %s\n", member.id);
            System.out.printf("이메일: %s\n", member.email);
            System.out.printf("암호: %s\n", member.password);
        }
    }

    static void onMemberUpdate() {
        System.out.println("[회원 정보 변경]");
        if (option == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            System.out.println();
            return;
        }

        int i = getMemberIndex(option);

        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member member = members[i];
            Member updateMember = new Member();
            System.out.printf("아이디(%s)? ", member.id);
            updateMember.id = keyScan.nextLine();
            System.out.printf("이메일(%s)? ", member.email);
            updateMember.email = keyScan.nextLine();
            System.out.printf("암호? ");
            updateMember.password = keyScan.nextLine();
            members[i] = updateMember;
            System.out.println("변경하였습니다.");
        }
    }

    static void onMemberDelete() {
        System.out.println("[회원 정보 삭제]");
        if (option == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return; //값을 리턴하면 안되기 때문에 return 명령만 작성한다.
                    //의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }

        int i = getMemberIndex(option);

        if (i == -1) {
            System.out.println("해당 이름의 아이디가 없습니다.");
        } else {
           if(Console.confirm("정말 삭제하시겠습니까?")) {
               members[i] = null;
               System.out.println("삭제하였습니다.");
           }
        }
    }


    public static void main(String[] args) {
        //클래스를 사용하기 전에 필수 값을 설정한다.
        TeamController.keyScan = keyScan;
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
            } else if (menu.equals("team/add")) {
                TeamController.onTeamAdd();
            } else if (menu.equals("team/list")) {
                TeamController.onTeamList();
            } else if (menu.equals("team/view")) {
                TeamController.onTeamView(option);
            } else if (menu.equals("team/update")) {
                TeamController.onTeamUpdate(option);
            } else if (menu.equals("team/delete")) {
                TeamController.onTeamDelete(option);
            } else if (menu.equals("member/add")) {
                onMemberAdd();
            } else if (menu.equals("member/list")) {
                onMemberList();
            } else if (menu.equals("member/view")) {
                onMemberView();
            } else if (menu.equals("member/update")) {
                onMemberUpdate();
            } else if (menu.equals("member/delete")) {
                onMemberDelete();
            } else {
                System.out.println("명령어가 올바르지 않습니다.");
            }
            System.out.println();
        }

    }
}
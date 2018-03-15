//회원 관련 기능을 모두 둔 클래스
package bitcamp.java106.pms.controller;

import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.util.Console;
import java.util.Scanner;

public class MemberController {
    //이 클래스를 사용하려면 keyboard 스캐너가 있어야 한다./
    //이 클래스를 사용하기 전에 스캐너를 설정하라!
    public static Scanner keyScan;

    static Member[] members = new Member[1000];
    static int memberIndex = 0;

    public static void service(String menu, String option) {
        if (menu.equals("member/add")) {
            onMemberAdd();
        } else if (menu.equals("member/list")) {
            onMemberList();
        } else if (menu.equals("member/view")) {
            onMemberView(option);
        } else if (menu.equals("member/update")) {
            onMemberUpdate(option);
        } else if (menu.equals("member/delete")) {
            onMemberDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }

    static int getMemberIndex(String id) { //바깥에서 호출 x, public x
        for (int i = 0; i < memberIndex; i++) {
            if(members[i] == null) continue;            
            if (id.equals(members[i].id.toLowerCase())) {
                return i;
            }
        }
        return -1;
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

    static void onMemberView(String id) {
        System.out.println("[회원 정보 조회]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            System.out.println();
            return;
        }

        int i = getMemberIndex(id);

        if (i == -1) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            Member member = members[i];
            System.out.printf("아이디: %s\n", member.id);
            System.out.printf("이메일: %s\n", member.email);
            System.out.printf("암호: %s\n", member.password);
        }
    }

    static void onMemberUpdate(String id) {
        System.out.println("[회원 정보 변경]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            System.out.println();
            return;
        }

        int i = getMemberIndex(id);

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

    static void onMemberDelete(String id) {
        System.out.println("[회원 정보 삭제]");
        if (id == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            return; //값을 리턴하면 안되기 때문에 return 명령만 작성한다.
                    //의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }

        int i = getMemberIndex(id);

        if (i == -1) {
            System.out.println("해당 이름의 아이디가 없습니다.");
        } else {
           if(Console.confirm("정말 삭제하시겠습니까?")) {
               members[i] = null;
               System.out.println("삭제하였습니다.");
           }
        }
    }


}
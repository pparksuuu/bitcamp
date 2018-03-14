package bitcamp.java106.pms; //java가 root folder이기 때문임.

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.Scanner;

//ver 0.5 - member/add,list,view 명령어를 처리하는 코드를 메서드로 분리한다.
//ver 0.4 - team/add,list,view 명령어를 처리하는 코드를 메서드로 분리한다.
//ver 0.3 - help 명령어를 처리하는 코드를 메서드로 분리한다.
//ver 0.2 - quit 명령어를 처리하는 코드를 메서드로 분리한다.
//ver 0.1 - 명령어를 입력 받는 코드를 메서드로 분리한다.
public class App {
    // 클래스 변수 = 스태틱 변수
    // => 클래스 안 어디에서나 사용할 수 있는 변수.
    static Scanner keyScan = new Scanner(System.in);
    
    //클래스 변수는 이 클래스의 모든 메서드에서 사용할 수 있다.
    static Team[] teams = new Team[1000];
    static int teamIndex = 0;
    static String option = null; 

    static Member[] members = new Member[1000];
    static int memberIndex = 0;

    static String[] prompt() {
        System.out.print("명령>");
        return keyScan.nextLine().toLowerCase().split(" ");
    }

    static void onQuit() {
        System.out.println("안녕히 가세요!");
    }


    static void onHelp() {
        System.out.println("[도움말]");
        System.out.println("팀 등록 명령 : team/add");
        System.out.println("팀 조회 명령 : team/list");
        System.out.println("팀 상세조회 명령 : team/view 팀명");
        System.out.println("팀 정보 변경 : team/update 팀명");        
        System.out.println("팀 삭제 : team/delete 팀명");        
        System.out.println("회원 등록 명령 : member/add");
        System.out.println("회원 조회 명령 : member/list");
        System.out.println("회원 상세조회 명령 : member/view 아이디");
        System.out.println("회원 정보 변경 : member/update 아이디");        
        System.out.println("회원 삭제 : member/delete 아이디");        
        System.out.println("종료 : quit");
    }
    
    static void onTeamAdd() {
        System.out.println("[팀 정보입력]");
        Team team = new Team();

        System.out.print("팀명? ");
        team.teamName = keyScan.nextLine();

        System.out.print("설명? ");
        team.description = keyScan.nextLine();

        System.out.print("최대인원? ");
        team.maxQty = keyScan.nextInt();
        keyScan.nextLine();

        System.out.print("시작일? ");
        team.startDate = keyScan.nextLine();

        System.out.print("종료일? ");
        team.endDate = keyScan.nextLine();

        teams[teamIndex++] = team;

    }

    static void onTeamList() {
        System.out.println("[팀 목록]");
        for (int i = 0; i < teamIndex; i ++) {
            System.out.printf("%s, %d, %s ~ %s \n",
            teams[i].teamName, teams[i].maxQty, 
            teams[i].startDate, teams[i].endDate);  
        }
    }
    
    static void onTeamView() {
        System.out.println("[팀 정보 조회]");
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            System.out.println();
            return; //값을 리턴하면 안되기 때문에 return 명령만 작성한다.
                    //의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }
        Team team = null; //객체 없음.
        for (int i = 0; i < teamIndex; i++) {
            if (option.equals(teams[i].teamName.toLowerCase())) {
                team = teams[i];
                break;
            }
        }

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            System.out.printf("팀명: %s\n", team.teamName);
            System.out.printf("설명: %s\n", team.description);
            System.out.printf("최대인원: %d\n", team.maxQty);
            System.out.printf("기간: %s ~ %s\n",
             team.startDate, team.endDate);
        }

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
        Member member = null; //객체 없음.
        for (int i = 0; i < memberIndex; i++) {
            if (option.equals(members[i].id.toLowerCase())) {
                member = members[i];
                break;
            }
        }

        if (member == null) {
            System.out.println("해당 아이디의 회원이 없습니다.");
        } else {
            System.out.printf("아이디: %s\n", member.id);
            System.out.printf("이메일: %s\n", member.email);
            System.out.printf("암호: %s\n", member.password);
        }
    }

    static void onTeamUpdate() {
        System.out.println("[팀 정보 변경]");
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            System.out.println();
            return; 
        }
        Team team = null; //객체 없음.
        for (int i = 0; i < teamIndex; i++) {
            if (option.equals(teams[i].teamName.toLowerCase())) {
                team = teams[i];
                break;
            }
        }

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {

            System.out.printf("팀명(%s)? ",team.teamName);
            team.teamName = keyScan.nextLine();

            System.out.printf("설명(%s)? ",team.description);
            team.description = keyScan.nextLine();

            System.out.printf("최대인원(%d)? ",team.maxQty);
            team.maxQty = keyScan.nextInt();
            keyScan.nextLine();

            System.out.printf("시작일(%s)? ",team.startDate);
            team.startDate = keyScan.nextLine();

            System.out.printf("종료일(%s)? ",team.endDate);
            team.endDate = keyScan.nextLine();
        }
    }

    static void onTeamDelete() {
        System.out.println("[팀 삭제]");
        if (option == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            System.out.println();
            return; 
        }

        int deleteIndex = 0; //지울 팀이 위치한 레퍼런스 인덱스 값을 받아온다
        Team team = null; //객체 없음.
        for (int i = 0; i < teamIndex; i++) {
            if (option.equals(teams[i].teamName.toLowerCase())) {
                team = teams[i];
                deleteIndex = i;
                break;
            }
        }

        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            System.out.print("정말 삭제하시겠습니까?(Y/n) ");
            String delete = keyScan.nextLine().toLowerCase();

            if(delete.equals("n")) {
                System.out.println("삭제를 취소했습니다.");
            } else {
 
                if(deleteIndex == teamIndex) {
                    teams[0] = null;
                    return;
                } //둘 다 첫번째를 가리키는 경우 초기화

                //deleteIndex의 reference가 다음 인스턴스를 가리키게 연쇄적으로
                for(int i = deleteIndex; i < teamIndex; i++) {
                    teams[i] = teams[i+1];
                }
                teamIndex--;

                System.out.println("삭제하였습니다.");
  
            }
        }

    }

    static void onMemberUpdate() {
        System.out.println("[회원 정보 변경]");
        if (option == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            System.out.println();
            return; 
        }
        Member member = null; //객체 없음.
        for (int i = 0; i < memberIndex; i++) {
            if (option.equals(members[i].id.toLowerCase())) {
                member = members[i];
                break;
            }
        }

        if (member == null) {
            System.out.println("해당 이름의 회원이 없습니다.");
        } else {
            System.out.printf("아이디(%s)? ", member.id);
            member.id = keyScan.nextLine();

            System.out.printf("이메일(%s)? ", member.email);
            member.email = keyScan.nextLine();

            System.out.printf("비밀번호(%s)? ", member.password);
            member.password = keyScan.nextLine();
        }
    }

    static void onMemberDelete() {
        System.out.println("[회원 삭제]");
        if (option == null) {
            System.out.println("아이디를 입력하시기 바랍니다.");
            System.out.println();
            return; 
        }

        int deleteIndex = 0; //지울 팀이 위치한 레퍼런스 인덱스 값을 받아온다
        Member member = null; //객체 없음.
        for (int i = 0; i < memberIndex; i++) {
            if (option.equals(members[i].id.toLowerCase())) {
                member = members[i];
                deleteIndex = i;
                break;
            }
        }

        if (member == null) {
            System.out.println("해당 이름의 회원이 없습니다.");
        } else {
            System.out.print("정말 삭제하시겠습니까?(Y/n) ");
            String delete = keyScan.nextLine().toLowerCase();

            if(delete.equals("n")) {
                System.out.println("삭제를 취소했습니다.");
            } else {
 
                if(deleteIndex == memberIndex) {
                    members[0] = null;
                    return;
                } //둘 다 첫번째를 가리키는 경우 초기화

                //deleteIndex의 reference가 다음 인스턴스를 가리키게 연쇄적으로
                for(int i = deleteIndex; i < memberIndex; i++) {
                    members[i] = members[i+1];
                }
                memberIndex--;

                System.out.println("삭제하였습니다.");
  
            }
        }

    }



    public static void main(String[] args) {

        while (true) {
            String[] arr = prompt();

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
                onTeamAdd();
            } else if (menu.equals("team/list")) {
                onTeamList();
            } else if (menu.equals("team/view")) {
                onTeamView();
            } else if (menu.equals("team/update")) {
                onTeamUpdate();
            } else if (menu.equals("team/delete")) {
                onTeamDelete();
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
            }else {
                System.out.println("명령어가 올바르지 않습니다.");
            }
            System.out.println();
        }

    }
}
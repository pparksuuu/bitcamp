package bitcamp.java106.pms; //java가 root folder이기 때문임.

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.Scanner;

//ver 0.8 - team/view 명령을 구현한다.
    // 1단계: 입력 값에서 명령어와 검색어를 구분한다.
    // 2단계: 기능이나 코드가 바뀌면 그에 따라 적절히 변수명도 바뀔 필요가 있다.(다시실행)
    // 3단계: 입력 값에서 검색어를 별도의 변수에 저장
    // 4단계: 팀명이 없으면 안내문구를 출력한다.    
    // 5단계: 팀명으로 배열을 뒤져 팀 정보를 찾는다.
    // 6단계: 팀명으로 검색할 때 대소문자를 구분하지 않는다.(line 93)
//ver 0.7 - team/list 명령을 구현한다.
//ver 0.6 - team/add 명령을 구현한다. 
//ver 0.5 - help 명령어를 구현하라.
//ver 0.4 - quit 명령어 입력 시 반복문을 종료한다.
//ver 0.3 - 사용자로부터 입력 받는 것을 무한 반복한다. 
//ver 0.2 - 사용자 입력을 받아 출력한다.
//ver 0.1 - 명령 입력 프롬프트를 실행한다.
public class App {
    public static void main(String[] args) {

        Scanner keyScan = new Scanner(System.in);

        Team[] teams = new Team[1000]; //team 객체의 "주소"를 1000개 받는 것.
        int teamIndex = 0;

        while(true) {
            System.out.print("명령>");
            String[] arr = keyScan.nextLine().toLowerCase().split(" ");
            String menu = arr[0];
            //입력 받은 문자열을 공백으로 잘라서 명령과 검색어로 구분한다.
            //일단 다음으로 진행하기 전에 기존의 기능이 잘 되는지 확인하라!
            String option = null; //주소 없음!
            if (arr.length == 2) {
                option = arr[1];
            }

            if (menu.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
                
            } else if (menu.equals("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");

            } else if (menu.equals("team/add")) {
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

            } else if (menu.equals("team/list")) {
                System.out.println("[팀 목록]");
                for (int i = 0; i < teamIndex; i ++) {
                    System.out.printf("%s, %d, %s ~ %s \n",
                    teams[i].teamName, teams[i].maxQty, 
                    teams[i].startDate, teams[i].endDate);  
                }

            } else if (menu.equals("team/view")) {
                System.out.println("[팀 정보 조회]");
                if (option == null) {
                    System.out.println("팀명을 출력하시기 바랍니다.");
                    System.out.println();
                    continue;
                }

                for (int i = 0; i < teamIndex; i++) {
                    if (option.equals(teams[i].teamName.toLowerCase())) {
                        System.out.printf("팀명: %s\n", teams[i].teamName);
                        System.out.printf("설명: %s\n", teams[i].description);
                        System.out.printf("최대인원: %d\n", teams[i].maxQty);
                        System.out.printf("기간: %s ~ %s\n",
                         teams[i].startDate, teams[i].endDate);
                    }
                }
                System.out.println(option);
            }

            System.out.println();
        }

    }
}
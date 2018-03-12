package bitcamp.java106.pms; //java가 root folder이기 때문임.

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.domain.Member;
import java.util.Scanner;

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
            String input = keyScan.nextLine().toLowerCase();

            if(input.equals("quit")) {
                System.out.println("안녕히 가세요!");
                break;
            } else if(input.equals("help")) {
                System.out.println("[도움말]");
                System.out.println("팀 등록 명령 : team/add");
                System.out.println("팀 조회 명령 : team/list");
                System.out.println("팀 상세조회 명령 : team/view 팀명");
                System.out.println("회원 등록 명령 : member/add");
                System.out.println("회원 조회 명령 : member/list");
                System.out.println("회원 상세조회 명령 : member/view 아이디");
                System.out.println("종료 : quit");
                System.out.println();
                continue; //아래는 더 이상 실행하지 않고, while문의 시작으로 감.
            } else if(input.equals("team/add")) {
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

                System.out.println();
                continue;
            } else if(input.equals("team/list")) {
                System.out.println("[팀 목록]");
                for(int i = 0; i < teamIndex; i ++) {
                    System.out.printf("%s, %d, %s ~ %s \n",
                    teams[i].teamName, teams[i].maxQty, 
                    teams[i].startDate, teams[i].endDate);  
                }
                System.out.println();
                continue;
            }

            System.out.println(input);
        }
        // Team[] teams = new Team[100];
        // Member[] members = new Member[100];

        
        // int tCount = 0;
        // int mCount = 0;
        
        // while(true) {

        //     System.out.println();
        //     System.out.print("명령> ");
        //     String str = keyScan.nextLine();
        //     //명령어를 받아와서 공백으로 구분해서 배열로 반환.
        //     String[] inputs = str.split(" ");
        //     //String[] inputs = str.split("\\s");

        //         if(inputs[0].equals("help")) {
        //             System.out.println("팀 등록 명령 : team/add");
        //             System.out.println("팀 조회 명령 : team/list");
        //             System.out.println("팀 상세조회 명령 : team/view 팀명");
        //             System.out.println("회원 등록 명령 : member/add");
        //             System.out.println("회원 조회 명령 : member/list");
        //             System.out.println("회원 상세조회 명령 : member/view 아이디");
        //             System.out.println("종료 : quit");
        //         }

        //         else if(inputs[0].equals("team/add")) {

        //             if(tCount == teams.length) {
        //                 System.out.println("더 이상 팀을 만들 수 없습니다.");
        //             }
                    
        //             else {
        //                 teams[tCount] = new Team();

        //                 System.out.print("팀명? ");
        //                 teams[tCount].teamName = keyScan.nextLine();
        //                 System.out.print("설명? ");
        //                 teams[tCount].description = keyScan.nextLine();
        //                 System.out.print("최대인원? ");
        //                 teams[tCount].maxQty = keyScan.nextInt();
        //                 keyScan.nextLine();
        //                 System.out.print("시작일? ");
        //                 teams[tCount].startDate = keyScan.nextLine();
        //                 System.out.print("종료일? ");
        //                 teams[tCount].endDate = keyScan.nextLine();
        //                 tCount++;
        //             }


        //         }

        //         else if(inputs[0].equals("team/list")) {
        //             for(int i = 0; i < tCount; i++) {
        //                 System.out.printf("%s, %d명, %s ~ %s\n",
        //                 teams[i].teamName, teams[i].maxQty,
        //                 teams[i].startDate, teams[i].endDate);
        //             }
                    
        //         }

        //         else if(inputs[0].equals("team/view")) {
        //             //3가지 경우가 있음. 
        //             //if문에는 긍정의 조건을 넣어야 가독성 좋음
                    
        //             if(inputs.length == 1)
        //             {
        //                 System.out.println("팀명을 입력하시기 바랍니다.");
        //             }
        //             else {
        //                 boolean exist = false;
        //                 int t=0;
        //                 for(int i =0; i < tCount; i++) {
        //                     if(inputs[1].equals(teams[i].teamName))
        //                     {
        //                         t = i;
        //                         exist = true;
        //                         break;
        //                     }
        //                 }
        //                 if(exist == true) {
        //                     System.out.printf("팀명: %s\n설명:%s\n최대인원: %d명\n기간: %s ~ %s\n",
        //                     teams[t].teamName,teams[t].description,
        //                     teams[t].maxQty,
        //                     teams[t].startDate, teams[t].endDate);
        //                 }
        //                 else {
        //                     System.out.println("해당 이름의 팀이 없습니다.");
        //                 }
        //             }
                 
        //         }

        //         else if(inputs[0].equals("member/add")) {
        //             members[mCount] = new Member();

        //             System.out.print("아이디? ");
        //             members[mCount].id = keyScan.nextLine();
        //             System.out.print("이메일? ");
        //             members[mCount].email = keyScan.nextLine();
        //             System.out.print("암호? ");
        //             members[mCount].pwd = keyScan.nextLine();
        //             mCount++;
        //         }

        //         else if(inputs[0].equals("member/list")) {
        //             for(int i = 0; i < mCount; i++) {
        //                 System.out.printf("%s, %s, %s\n",
        //                 members[i].id, members[i].email, members[i].pwd);
        //             }
        //         }

        //         else if(inputs[0].equals("member/view")) {
        //             if(inputs.length == 1)
        //             {
        //                 System.out.println("아이디를 입력하시기 바랍니다.");
        //             }
        //             else {
        //                 boolean exist = false;
        //                 int t=0;
        //                 for(int i =0; i < mCount; i++) {
        //                     if(inputs[1].equals(members[i].id))
        //                     {
        //                         t = i;
        //                         exist = true;
        //                         break;
        //                     }
        //                 }
        //                 if(exist == true) {
        //                     System.out.printf("아이디: %s\n이메일: %s\n암호: %s\n",
        //                     members[t].id, members[t].email,
        //                     members[t].pwd);
        //                 }
        //                 else {
        //                     System.out.println("해당 아이디의 회원이 없습니다.");
        //                 }
        //             }
        //         }

        //         else if(inputs[0].equals("quit")) {
        //             System.out.println("안녕히 가십시오!");
        //             break;
        //         }

        //         else {
        //             System.out.println("명령어가 올바르지 않습니다.");
        //         }

        // }




    }
}
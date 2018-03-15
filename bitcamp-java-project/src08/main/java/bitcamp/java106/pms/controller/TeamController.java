//팀 관련 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;
import java.util.Scanner;

public class TeamController {
    //이 클래스를 사용하기 전에 App 클래스에서 준비한 Scanner 객체를
    //keyScan 변수에 저장하라!
    public static Scanner keyScan;

    static Team[] teams = new Team[1000];
    static int teamIndex = 0;

    static int getTeamIndex(String teamName) { //Team 내부에서만 쓰기 때문에 공개X
        for (int i = 0; i < teamIndex; i++) {
            if (teams[i] == null) continue;
            if (teamName.equals(teams[i].teamName.toLowerCase())) {
                    return i;
            }
        }
        return -1; //-1이라는 인덱스는 없지만, 못찾았다는 의미로 -1을 넣어준 것.
    }

    public static void onTeamAdd() { //당장 App에서 쓰기 때문에 공개하는 것
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

    public static void onTeamList() {
        System.out.println("[팀 목록]");
        for (int i = 0; i < teamIndex; i ++) {
            if (teams[i] == null) continue;
            System.out.printf("%s, %d, %s ~ %s \n",
            teams[i].teamName, teams[i].maxQty, 
            teams[i].startDate, teams[i].endDate);  
        }
    }
    
    public static void onTeamView(String teamName) {
        System.out.println("[팀 정보 조회]");
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            System.out.println();
            return; //값을 리턴하면 안되기 때문에 return 명령만 작성한다.
                    //의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }

        int i = getTeamIndex(teamName);

        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team team = teams[i];
            System.out.printf("팀명: %s\n", team.teamName);
            System.out.printf("설명: %s\n", team.description);
            System.out.printf("최대인원: %d\n", team.maxQty);
            System.out.printf("기간: %s ~ %s\n",
             team.startDate, team.endDate);
        }

    }    

    public static void onTeamUpdate(String teamName) {
        System.out.println("[팀 정보 변경]");
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");

            return; //값을 리턴하면 안되기 때문에 return 명령만 작성한다.
                    //의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }

        int i = getTeamIndex(teamName);


        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            Team team = teams[i];
            Team updateTeam = new Team();
            System.out.printf("팀명(%s)? ", team.teamName);
            updateTeam.teamName = keyScan.nextLine();
            System.out.printf("설명(%s)? ", team.description);
            updateTeam.description = keyScan.nextLine();
            System.out.printf("최대인원(%d)? ", team.maxQty);
            updateTeam.maxQty = keyScan.nextInt();
            keyScan.nextLine();
            System.out.printf("시작일(%s)? ", team.startDate);
            updateTeam.startDate = keyScan.nextLine();
            System.out.printf("종료일(%s)? ", team.endDate);
            updateTeam.endDate = keyScan.nextLine();
            teams[i] = updateTeam;
            System.out.println("변경하였습니다");
        }
    }

    public static void onTeamDelete(String teamName) {
        System.out.println("[팀 정보 삭제]");
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; //값을 리턴하면 안되기 때문에 return 명령만 작성한다.
                    //의미? 즉시 메서드 실행을 멈추고 이전 위치로 돌아간다.
        }

        int i = getTeamIndex(teamName);

        if (i == -1) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
           
           if(Console.confirm("정말 삭제하시겠습니까?")) {
               teams[i] = null;
               System.out.println("삭제하였습니다.");
           }
        }

    }

}
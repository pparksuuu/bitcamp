// 팀 멤버 관리 기능을 모아 둔 클래스
package bitcamp.java106.pms.controller;

import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TeamMemberController {
    
    Scanner keyScan;
    TeamDao teamDao;
    MemberDao memberDao;
    
    Team[] teams = new Team[1000];
    int teamIndex = 0;

    public TeamMemberController(Scanner scanner, TeamDao teamDao, MemberDao memberDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.memberDao = memberDao;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("team/member/add")) {
            this.onTeamMemberAdd(option);
        } else if (menu.equals("team/member/list")) {
            System.out.println("[팀 멤버 목록]");
            //this.onTeamMemberList();
        } else if (menu.equals("team/member/delete")) {
            System.out.println("[팀 멤버 삭제]");
            //this.onTeamMemberDelete(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }


    void onTeamMemberAdd(String teamName) {
        System.out.println("[팀 멤버 추가]");
        Team team = teamDao.get(teamName);
        if (team == null) { 
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        System.out.println("추가할 멤버의 아이디는? ");
        String memberId = keyScan.nextLine();
        
        Member member = memberDao.get(memberId);
        if(member == null) {
            System.out.printf("%s 회원은 없습니다", memberId);
            return;
        }
       /*
        Team team = new Team();

        System.out.print("팀명? ");
        team.name = this.keyScan.nextLine();

        System.out.print("설명? ");
        team.description = this.keyScan.nextLine();

        System.out.print("최대인원? ");
        team.maxQty = this.keyScan.nextInt();
        this.keyScan.nextLine(); 

        System.out.print("시작일? ");
        team.startDate = Date.valueOf(this.keyScan.nextLine());

        System.out.print("종료일? ");
        team.endDate = Date.valueOf(this.keyScan.nextLine());

        teamDao.insert(team);
        */
    }

    void onTeamMemberList() {
        System.out.println("[팀 목록]");
        Team[] list = teamDao.list();
        for (int i = 0; i < list.length; i++) {
            if (list[i] == null) continue;
            System.out.printf("%s, %d, %s ~ %s\n", 
                    list[i].name, list[i].maxQty, 
                    list[i].startDate, list[i].endDate);
        }
    }

    void onTeamMemberDelete(String name) {
        System.out.println("[팀 정보 삭제]");
        if (name == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(name);
        
        if (team == null) {
            System.out.println("해당 이름의 팀이 없습니다.");
        } else {
            if (Console.confirm("정말 삭제하시겠습니까?")) {
                teamDao.delete(name);
                System.out.println("삭제하였습니다.");
            }
        }
    }
    
}
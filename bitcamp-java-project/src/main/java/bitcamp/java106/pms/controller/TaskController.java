package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;

public class TaskController {

    Scanner keyScan;
    TaskDao taskDao;
    TeamDao teamDao;
    MemberDao memberDao;
    
    public TaskController(Scanner scanner, TaskDao taskDao,
            TeamDao teamDao, MemberDao memberDao) {
        this.keyScan = scanner;
        this.taskDao = taskDao;
        this.teamDao = teamDao;
        this.memberDao = memberDao;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("task/add")) {
            this.onTaskAdd(option);
        } else if (menu.equals("task/list")) {
            //this.onTaskList(option);
        } else if (menu.equals("task/view")) {
            //this.onTaskList(option);
        } else if (menu.equals("task/update")) {
            //this.onTaskList(option);
        } else if (menu.equals("task/delete")) {
            //this.onTaskDelete(option);
        } else if (menu.equals("task/state")) {
            //this.onTaskList(option);
        } else {
            System.out.println("명령어가 올바르지 않습니다.");
        }
    }
    

    void onTaskAdd(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        Task task = new Task();
        
        System.out.println("[작업 추가]");
        
        System.out.print("작업명? ");
        task.setTitle(keyScan.nextLine());
        
        System.out.print("시작일? ");
        task.setStartDate(Date.valueOf(keyScan.nextLine()));
        
        System.out.print("종료일? ");
        task.setEndDate(Date.valueOf(keyScan.nextLine()));
        
        
        System.out.println("작업자?" );
        String memberId = keyScan.nextLine();
        
        if ((memberId.length() != 0)) {
            
        } else {
            Member member = memberDao.get(memberId);
            if (member == null) {
                System.out.printf("%s 회원은 없습니다. 작업자를 비워두겠습니다",
                        memberId);
                task.setMember(null);
            } else {
                task.setMember(member);
            }
        }
        
    }

//    void onTeamMemberList(String teamName) {
//        if (teamName == null) {
//            System.out.println("팀명을 입력하시기 바랍니다.");
//            return; 
//        }
//        
//        Team team = teamDao.get(teamName);
//        if (team == null) {
//            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
//            return;
//        }
//
//        System.out.println("[팀 멤버 목록]");
//        System.out.print("회원들: ");
//        Member[] members = team.getMembers();
//        for (int i = 0; i < members.length; i++) {
//            if (members[i] == null) continue;
//            System.out.printf("%s, ", members[i].getId());
//        }
//        System.out.println();
//    }
//
//    void onTeamMemberDelete(String teamName) {
//        if (teamName == null) {
//            System.out.println("팀명을 입력하시기 바랍니다.");
//            return; 
//        }
//        
//        Team team = teamDao.get(teamName);
//        if (team == null) {
//            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
//            return;
//        }
//        
//        System.out.print("삭제할 팀원은? ");
//        String memberId = keyScan.nextLine();
//        
//        if (!team.isExist(memberId)) {
//            System.out.println("이 팀의 회원이 아닙니다.");
//            return;
//        }
//
//        team.deleteMember(memberId);
//        
//        System.out.println("[팀 멤버 삭제]");
//        System.out.println("삭제하였습니다.");
//    }
}

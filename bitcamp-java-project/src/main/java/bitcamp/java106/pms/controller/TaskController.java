package bitcamp.java106.pms.controller;

import java.sql.Date;
import java.util.Scanner;

import bitcamp.java106.pms.dao.MemberDao;
import bitcamp.java106.pms.dao.TaskDao;
import bitcamp.java106.pms.dao.TeamDao;
import bitcamp.java106.pms.domain.Member;
import bitcamp.java106.pms.domain.Task;
import bitcamp.java106.pms.domain.Team;
import bitcamp.java106.pms.util.Console;

public class TaskController {
    Scanner keyScan;
    TeamDao teamDao;
    MemberDao memberDao;
    TaskDao taskDao;
    
    public TaskController(Scanner scanner, 
            TeamDao teamDao, MemberDao memberDao, TaskDao taskDao) {
        this.keyScan = scanner;
        this.teamDao = teamDao;
        this.memberDao = memberDao;
        this.taskDao = taskDao;
    }
    
    public void service(String menu, String option) {
        if (menu.equals("task/add")) {
            this.onTaskAdd(option);
        } else if (menu.equals("task/list")) {
            this.onTaskList(option);
        } else if (menu.equals("task/view")) {
            this.onTaskView(option);
        } else if (menu.equals("task/update")) {
            this.onTaskUpdate(option);
        } else if (menu.equals("task/delete")) {
            this.onTaskDelete(option);
        } else if (menu.equals("task/state")) {
            this.onTaskState(option);
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
        
        Task task = new Task(team);
        
        System.out.println("[작업 추가]");
        System.out.print("작업명? ");
        task.setTitle(keyScan.nextLine());
        
        System.out.print("시작일? ");
        String str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setStartDate(team.getStartDate());
        } else { 
            Date date = Date.valueOf(str);
            if (date.getTime() < team.getStartDate().getTime()) {
                task.setStartDate(team.getStartDate());
            } else {
                task.setStartDate(date);
            }
        }
        
        
        System.out.print("종료일? ");
        str = keyScan.nextLine();
        if (str.length() == 0) {
            task.setEndDate(team.getEndDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() > team.getEndDate().getTime()) {
                task.setEndDate(team.getEndDate());
            } else
            {
                task.setEndDate(date);
            }
        }
        
        System.out.print("작업자? ");
        String memberId = keyScan.nextLine();
        
        if (memberId.length() != 0) {
            Member member = team.getMember(memberId);
            if (member == null) {
                System.out.printf("'%s'는 이 팀의 회원이 아닙니다. 작업자는 비워두겠습니다.", memberId);
            } else {
             
                task.setWorker(member);
            }
        }
        
        taskDao.insert(task);
    }

    void onTaskList(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }

        System.out.println("[작업 목록]");
        
        Task[] arr = taskDao.list(teamName);
        
        for (Task task : arr) {
            System.out.printf("%d, %s, %s, %s\n",
                    task.getNo(), 
                    task.getStartDate(), task.getEndDate(),
                    task.getWorker().getId());
        }
    }

    void onTaskView(String teamName) {
        
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        System.out.print("작업 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task task = taskDao.getTask(teamName, taskNo);
        
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.",
                    teamName, taskNo);
        }
        
        System.out.printf("작업명 : %s\n", task.getTitle());
        System.out.printf("시작일 : %s\n", task.getStartDate());
        System.out.printf("종료일 : %s\n", task.getEndDate());
        System.out.printf("작업자 : %s\n", 
                task.getWorker() == null ?
                "" : task.getWorker().getId());
        System.out.printf("작업상태 : %s",getTaskState(task.getState()));
    }
    
    void onTaskState(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        

        System.out.print("상태를 변경할 작업 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task task = taskDao.getTask(teamName, taskNo);
        
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.",
                    teamName, taskNo);
            return;
        }
        
        System.out.printf("'%s' 작업의 상태 : %s\n",
                task.getTitle(), getTaskState(task.getState()));
        
        System.out.print("변경할 상태? (0: 작업대기, 1: 작업중, 9: 작업완료) ");
        int state = Integer.parseInt(keyScan.nextLine());
        
        if (state == Task.READY || state == Task.WORKING || state == Task.COMPLETE) {
            task.setState(state);
            System.out.printf("작업 상태를 '%s'로 변경하였습니다.", getTaskState(state));
        } else {
            System.out.println("올바르지 않은 값입니다. 이전 상태를 유지합니다.");
        }
        

    }
    
    void onTaskDelete(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        
        System.out.print("삭제할 작업의 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task task = taskDao.getTask(teamName, taskNo);
        
        if (task == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.",
                    teamName, taskNo);
            return;
        }
        
        taskDao.delete(task);
    }
    
    void onTaskUpdate(String teamName) {
        if (teamName == null) {
            System.out.println("팀명을 입력하시기 바랍니다.");
            return; 
        }
        
        Team team = teamDao.get(teamName);
        if (team == null) {
            System.out.printf("%s 팀은 존재하지 않습니다.", teamName);
            return;
        }
        

        System.out.print("변경할 작업 번호? ");
        int taskNo = Integer.parseInt(keyScan.nextLine());
        
        Task oldTask = taskDao.getTask(teamName, taskNo);
        
        if (oldTask == null) {
            System.out.printf("'%s'팀의 %d번 작업을 찾을 수 없습니다.",
                    teamName, taskNo);
            return;
        }
        
        Task task = new Task(team);
        task.setNo(oldTask.getNo());
        
        System.out.printf("작업명(%s)? ", oldTask.getTitle());
        task.setTitle(keyScan.nextLine());
        
        System.out.printf("시작일 (%s)? ", oldTask.getStartDate());
        String str = keyScan.nextLine();
        if (str.length()==0) {
            task.setStartDate(oldTask.getStartDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() < oldTask.getStartDate().getTime()) {
                task.setEndDate(oldTask.getStartDate());
            } else {
                task.setStartDate(date);
            }
        }
            
        
        System.out.printf("종료일 (%s)? ", oldTask.getEndDate());
        str = keyScan.nextLine();
        if (str.length()==0) {
            task.setStartDate(oldTask.getStartDate());
        } else {
            Date date = Date.valueOf(str);
            if (date.getTime() > oldTask.getStartDate().getTime()) {
                task.setEndDate(oldTask.getStartDate());
            } else {
                task.setStartDate(date);
            }
        }
        
        System.out.printf("작업자 (%s)? ", 
                oldTask.getWorker() == null ?
                "-" : oldTask.getWorker().getId());
        
        String memberId = keyScan.nextLine();
        if (memberId.length() == 0) {
            task.setWorker(oldTask.getWorker());
        } else {
            Member member = team.getMember(memberId);
            if (member == null) {
                System.out.printf("'%s'는 이 팀의 회원이 아닙니다. 작업자는 비워두겠습니다.\n", memberId);
            } else {
                task.setWorker(member);
            }
        }
       
        if (Console.confirm("변경하시겠습니까?")) {
            taskDao.update(task);
        } else {
            System.out.println("취소하였습니다.");
        }
        
    }
    
    public static String getTaskState(int state) {
        switch(state) {
        case Task.READY: return "작업대기";
        case Task.WORKING: return "작업중";
        case Task.COMPLETE: return "작업완료";
        default:
            return null;
        }
    }
}

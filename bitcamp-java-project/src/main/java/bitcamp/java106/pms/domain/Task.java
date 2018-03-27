package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Task {
    public static final int READY = 0;
    public static final int WORKING = 1;
    public static final int COMPLETE = 9;
    
    private int no;
    private String title;
    private int state;
    private Date startDate;
    private Date endDate;
    private Member worker;
    private Team team;
    
    public Task(Team team) {
        this.team = team;
        this.state = READY;
    }
    
    public int getNo() {
        return no;
    }
    
    public void setNo(int no) {
        this.no = no;
    }
    
    public String getTitle() {
        return title;
    }
    
    public void setTitle(String title) {
        this.title = title;
    }
    
    public int getState() {
        return state;
    }
    
    public void setState(int state) {
        this.state = state;
    }
    
    public Date getStartDate() {
        return startDate;
    }
    
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }
    
    public Date getEndDate() {
        return endDate;
    }
    
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }
    
    public Member getWorker() {
        return worker;
    }
    
    public void setWorker(Member worker) {
        this.worker = worker;
    }
    
    public Team getTeam() {
        return team;
    }
    
    public void setTeam(Team team) {
        this.team = team;
    }

    @Override
    public String toString() {
        return "Task [no=" + no + ", title=" + title + ", state=" + state
                + ", startDate=" + startDate + ", endDate=" + endDate
                + ", worker=" + worker + ", team=" + team + "]";
    }
    
    
}

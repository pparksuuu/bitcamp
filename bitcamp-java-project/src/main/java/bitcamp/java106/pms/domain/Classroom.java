package bitcamp.java106.pms.domain;

import java.sql.Date;

public class Classroom {
    private static int count = 0;
    
    private int no;
    private String className;
    private Date startDate;
    private Date endDate;
    private String classNo;
    
    public Classroom() {
        no = count++;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getClassName() {
        return className;
    }

    public void setClassName(String className) {
        this.className = className;
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

    public String getClassNo() {
        return classNo;
    }

    public void setClassNo(String classNo) {
        this.classNo = classNo;
    }
    
    
}

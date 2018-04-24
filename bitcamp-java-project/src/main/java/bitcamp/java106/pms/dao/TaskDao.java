package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Task;

@Component
public class TaskDao {
    public int delete(int taskNo) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms_task where tano=?");) {
            
            stmt.setInt(1, taskNo);
            return stmt.executeUpdate();
        } 
    }
    
    public List<Task> selectList(String teamName) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select titl,sdt,edt,stat,mid,tnm from pms_task where tnm=?");
            ResultSet rs = stmt.executeQuery();) {
            
            stmt.setString(1, teamName);
            
            ArrayList<Task> arr = new ArrayList<>();
            while (rs.next()) {
                Task task = new Task(teamName);
                task.setTitle(rs.getString("titl"));
                task.setStartDate(rs.getDate("sdt"));
                task.setEndDate(rs.getDate("edt"));
                task.setWorkerName(rs.getString("mid"));
                task.setTeamName(rs.getString("tnm"));
                arr.add(task);
            }
            return arr;
        }
    }

    public int insert(Task task) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "insert into pms_task(titl,sdt,edt,stat,mid,tnm) values(?,?,?,?,?,?)");) {
            
            stmt.setString(1, task.getTitle());
            stmt.setDate(2, task.getStartDate());
            stmt.setDate(3, task.getEndDate());
            stmt.setInt(4, task.getState());
            stmt.setString(5, task.getWorker().getId());
            stmt.setString(6, task.getTeam().getName());
            return stmt.executeUpdate();
        }
    }

    public int update(Task task) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "update pms_task set titl=?, sdt=?, edt=?, stat=? where tano=?");) {
            
            stmt.setString(1, task.getTitle());
            stmt.setDate(2, task.getStartDate());
            stmt.setDate(3, task.getEndDate());
            stmt.setInt(4, task.getState());
            stmt.setInt(5, task.getNo());
            return stmt.executeUpdate();
        }
    }

    public Task selectOne(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select titl, sdt, edt, stat, mid, tnm from pms_task where tano=?");) {
            
            stmt.setInt(1, no);
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) 
                    return null;
                
                Task task = new Task(rs.getString("tnm"));
                task.setTitle(rs.getString("name"));
                task.setStartDate(rs.getDate("sdt"));
                task.setEndDate(rs.getDate("edt"));
                task.setState(rs.getInt("stat"));
                task.setWorkerName(rs.getString("mid"));
                task.setTeamName(rs.getString("tnm"));
                return task;
            }
        }  
    } 
}

//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 22 - 추상 클래스 AbstractDao를 상속 받는다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList 클래스를 적용하여 객체(의 주소) 목록을 관리한다.
// ver 17 - 클래스 생성






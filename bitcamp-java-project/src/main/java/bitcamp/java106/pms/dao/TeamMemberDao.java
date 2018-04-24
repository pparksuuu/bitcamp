package bitcamp.java106.pms.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import bitcamp.java106.pms.annotation.Component;
import bitcamp.java106.pms.domain.Board;
import bitcamp.java106.pms.domain.Member;

@Component
public class TeamMemberDao {
    public int delete(String teamName,String memberId) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "delete from pms_team_member where tnm=? and mid =?");) {
            
            stmt.setString(1, teamName);
            stmt.setString(2, memberId);
            return stmt.executeUpdate();
        } 
    }
    
    public List<String> selectList(String tnm) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select mid from pms_team_member where tnm=?");
            ResultSet rs = stmt.executeQuery();) {
            
            stmt.setString(1, tnm);
            
            ArrayList<String> arr = new ArrayList<>();
            while (rs.next()) {
                String mId = rs.getString("mid");
                arr.add(mId);
            }
            return arr;
        }
    }

    public int insert(Board board) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "insert into pms_team_member(titl,cont,cdt) values(?,?,now())");) {
            
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
        
            return stmt.executeUpdate();
        }
    }

    public int update(Board board) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "update pms_team_member set titl=?, cont=?, cdt=now() where bno=?");) {
            
            stmt.setString(1, board.getTitle());
            stmt.setString(2, board.getContent());
            stmt.setInt(3, board.getNo());
            return stmt.executeUpdate();
        }
    }

    public Board selectOne(int no) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        try (
            Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
            PreparedStatement stmt = con.prepareStatement(
                "select bno,titl,cont,cdt from pms_team_member where bno=?");) {
            
            stmt.setInt(1, no);
            
            try (ResultSet rs = stmt.executeQuery();) {
                if (!rs.next()) 
                    return null;
                
                Board board = new Board();
                board.setNo(rs.getInt("bno"));
                board.setTitle(rs.getString("titl"));
                board.setContent(rs.getString("cont"));
                board.setCreatedDate(rs.getDate("cdt"));
                return board;
            }
        }  
    }
}

// 용어 정리!
// 메서드 시그너처(method signature) = 함수 프로토타입(function prototype)
// => 메서드의 이름과 파라미터 형식, 리턴 타입에 대한 정보를 말한다.

//ver 24 - File I/O 적용
//ver 23 - @Component 애노테이션을 붙인다.
//ver 19 - 우리 만든 ArrayList 대신 java.util.LinkedList를 사용하여 목록을 다룬다. 
//ver 18 - ArrayList를 적용하여 객체(의 주소) 목록을 관리한다.
//ver 17 - 클래스 추가










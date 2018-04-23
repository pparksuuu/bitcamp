package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam03_view_member {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("조회할 멤버 아이디?");
        String id = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "select id,em,pw from ex_member where id=?");
        stmt.setString(1, id);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            System.out.printf("아이디: %s\n", rs.getString("id"));
            System.out.printf("이메일: %s\n", rs.getString("em"));
            System.out.printf("비밀번호: %s\n", rs.getString("pw"));
        }
        
        con.close();
        keyScan.close();
    }
}

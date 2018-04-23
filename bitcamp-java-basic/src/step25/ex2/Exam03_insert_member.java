package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam03_insert_member {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("아이디?");
        String id = keyScan.nextLine();
        
        System.out.print("이메일?");
        String email = keyScan.nextLine();
        
        System.out.print("비밀번호?");
        String password = keyScan.nextLine();
        
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        
        PreparedStatement stmt = con.prepareStatement(
                "insert into ex_member(id,em,pw) values(?,?,?)");
        
        stmt.setString(1, id);
        stmt.setString(2, email);
        stmt.setString(3, password);
        
        int count = stmt.executeUpdate();
        System.out.printf("%d개 입력 성공!", count);
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}

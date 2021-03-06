package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam03_delete_member {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("삭제할 멤버 아이디?");
        String id = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "delete from ex_member where id=?");
        
        stmt.setString(1, id);
        
        int count = stmt.executeUpdate();
        
        System.out.printf("%d 개 삭제 성공!", count);

        stmt.close();
        con.close();
        keyScan.close();
    }
}

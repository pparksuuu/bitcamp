package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam06_delete_teammember {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("삭제할 팀?");
        String teamName = keyScan.nextLine();
        
        System.out.print("삭제할 멤버 ? ");
        String memberId = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "delete from ex_teammember where tnm=? and mid=?");
        
        stmt.setString(1, teamName);
        stmt.setString(2, memberId);
        
        int count = stmt.executeUpdate();
        
        System.out.printf("%d개 삭제 성공!",count);
        
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}

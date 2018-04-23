package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam07_update_classroom {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.println("변경할 수업번호?");
        String cno = keyScan.nextLine();
        
        System.out.print("수업이름? ");
        String description = keyScan.nextLine();
        
        System.out.print("시작 날짜?");
        String startDate = keyScan.nextLine();
        
        System.out.print("종료 날짜?");
        String endDate = keyScan.nextLine();
        
        System.out.print("수업 번호? ");
        String rm = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "update ex_classroom set titl=?, sdt=?, edt=?, rm=? where cno=?");
        
        stmt.setString(1, description);
        stmt.setString(2, startDate);
        stmt.setString(3, endDate);
        stmt.setString(4, rm);
        stmt.setString(5, cno);
        
        int count = stmt.executeUpdate();
        System.out.printf("%d 개 변경 성공!", count);
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}

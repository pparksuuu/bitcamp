package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam04_update_team {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.println("변경할 팀 이름?");
        String teamName = keyScan.nextLine();
        
        System.out.print("내용? ");
        String description = keyScan.nextLine();
        
        System.out.print("최대 인원?");
        String maxQty = keyScan.nextLine();
        
        System.out.print("시작 날짜?");
        String startDate = keyScan.nextLine();
        
        System.out.print("종료 날짜?");
        String endDate = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "update ex_team set dsc=?, mqt=?, sdt=?, edt=? where nm=?");
        
        stmt.setString(1, description);
        stmt.setString(2, maxQty);
        stmt.setString(3, startDate);
        stmt.setString(4, endDate);
        stmt.setString(5, teamName);
        
        int count = stmt.executeUpdate();
        System.out.printf("%d 개 변경 성공!", count);
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}

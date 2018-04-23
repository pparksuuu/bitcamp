package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class Exam05_insert_task {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        System.out.print("작업 이름? ");
        String title = keyScan.nextLine();
        
        System.out.print("시작 날짜?");
        String startDate = keyScan.nextLine();
        
        System.out.print("종료 날짜?");
        String endDate = keyScan.nextLine();
        
        System.out.print("팀이름? ");
        String teamName = keyScan.nextLine();
        
        System.out.print("멤버아이디? ");
        String memberId = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "insert into ex_task(titl,sdt,edt,tnm,mid) values(?,?,?,?,?)");
        
        stmt.setString(1, title);
        stmt.setString(2, startDate);
        stmt.setString(3, endDate);
        stmt.setString(4, teamName);
        stmt.setString(5, memberId);
        
        int count = stmt.executeUpdate();
        System.out.printf("%d 개 입력 성공!", count);
        
        stmt.close();
        con.close();
        keyScan.close();
    }
}

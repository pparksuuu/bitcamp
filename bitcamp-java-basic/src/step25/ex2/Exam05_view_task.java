package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam05_view_task {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("조회할 작업 번호?");
        String taskName = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "select titl,sdt,edt,stt,tnm,mid from ex_task where tno=?");
        stmt.setString(1, taskName);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            System.out.printf("작업이름: %s\n", rs.getString("titl"));
            System.out.printf("시작날짜: %s\n", rs.getString("sdt"));
            System.out.printf("종료날짜: %s\n", rs.getString("edt"));
            System.out.printf("상태: %s\n", rs.getString("stt"));
            System.out.printf("팀이름: %s\n", rs.getString("tnm"));
            System.out.printf("멤버이름: %s\n", rs.getString("mid"));
        }
        
        con.close();
        keyScan.close();
    }
}

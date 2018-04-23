package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Exam04_view_team {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("조회할 팀 이름?");
        String teamName = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "select nm,dsc,mqt,sdt,edt from ex_team where nm=?");
        stmt.setString(1, teamName);
        ResultSet rs = stmt.executeQuery();
        
        if (rs.next()) {
            System.out.printf("팀이름: %s\n", rs.getString("nm"));
            System.out.printf("내용: %s\n", rs.getString("dsc"));
            System.out.printf("최대인원: %s\n", rs.getString("mqt"));
            System.out.printf("시작날짜: %s\n", rs.getString("sdt"));
            System.out.printf("종료날짜: %s\n", rs.getString("edt"));
        }
        
        con.close();
        keyScan.close();
    }
}

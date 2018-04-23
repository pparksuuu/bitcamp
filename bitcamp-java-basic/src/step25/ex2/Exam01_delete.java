// JDBC 프로그래밍 개요 - DBMS에 SQL문 보내기 : insert
package step25.ex2;

import java.sql.DriverManager;
import java.util.Scanner;

public class Exam01_delete {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        System.out.print("삭제할 게시물 번호? ");
        String no = keyScan.nextLine();
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        System.out.println("DBMS와 연결 완료 !");

        java.sql.Statement stmt = con.createStatement();

        int count = stmt.executeUpdate(
                "delete from ex_board where bno=" + no);
        System.out.printf("%d개 삭제 성공!", count);

        stmt.close();
        con.close();
        keyScan.close();
    }
}

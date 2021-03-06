// 게시판 관리 - 등록
package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.Scanner;

public class Exam01_insert {
    public static void main(String[] args) throws Exception {
        Scanner keyScan = new Scanner(System.in);
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        System.out.println("DBMS와 연결 완료 !");
        
        Statement stmt = con.createStatement();

        //사용자로부터 제목, 내용을 입력받는다
        System.out.print("제목? ");
        String title = keyScan.nextLine();
        System.out.print("내용? ");
        String content = keyScan.nextLine();
        
        String sql = String.format(
                "insert into ex_board(titl,cont,rdt) values('%s','%s',now())",
                title, content);
        
        int count = stmt.executeUpdate(sql);
        System.out.printf("%d 개 입력 성공!", count);
        
        
        stmt.close();
        con.close();
        keyScan.close();
        
    }
}

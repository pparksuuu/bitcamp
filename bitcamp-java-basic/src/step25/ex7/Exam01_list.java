// 게시물 관리 - 목록
package step25.ex7;

import java.sql.DriverManager;

public class Exam01_list {
    public static void main(String[] args) throws Exception {
        // 1) JDBC 드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        // 2) DBMS에 연결하기
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mariadb://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        java.sql.Statement stmt = con.createStatement();

        java.sql.ResultSet rs = stmt.executeQuery(
                "select bno,titl,rdt from ex_board");
        
        while (rs.next()) {
            System.out.printf("%d,%s,%s\n",
                    rs.getInt("bno"), // select 결과의 컬럼 번호이다. 1부터 시작! 'bno' 컬럼값
                    rs.getString("titl"), //'titl'컬럼값
                    rs.getDate("rdt")); // 'rdt' 컬럼값
        } 

        rs.close();
        stmt.close();
        con.close();
    }
}

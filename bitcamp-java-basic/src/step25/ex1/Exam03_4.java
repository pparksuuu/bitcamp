// JDBC 프로그래밍 개요 - DBMS에 SQL문 보내기 : insert
package step25.ex1;

import java.sql.DriverManager;

public class Exam03_4 {
    public static void main(String[] args) throws Exception {
        // 1) JDBC 드라이버 로딩
        Class.forName("com.mysql.cj.jdbc.Driver");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        // 2) DBMS에 연결하기
        java.sql.Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        System.out.println("DBMS와 연결 완료 !");

        // 3) SQL문을 서버에 보낼 객체를 얻는다.
        java.sql.Statement stmt = con.createStatement();

        // 4) Statement 객체를 사용하여 DBMS에 SQL문을 보낸다.
        //    => 리턴 값: 결과가 아니다! 서버에서 결과를 가져오는 일을 할 객체를 리턴한다.
        java.sql.ResultSet rs = stmt.executeQuery(
                "select bno,titl,cont,rdt from ex_board");
        // 아직 서버에서 결과를 가져오지 못했다.

        // 5) rersultSet 객체를 사용하여 서버에서 select의 결과 한 레코드(row)를 가져온다.
        
        while (rs.next()) {
            // 그래서 실무에서는 가능한 번호 대신 컬럼의 이름을 사용한다.
            System.out.printf("%d,%s,%s,%s\n",
                    rs.getInt("bno"), // select 결과의 컬럼 번호이다. 1부터 시작! 'bno' 컬럼값
                    rs.getString("titl"), //'titl'컬럼값
                    rs.getString("cont"), // 'cont' 컬럼값
                    rs.getDate("rdt")); // 'rdt' 컬럼값
        } 

        // 자원해제
        // => 파일과 마찬가지로 DBMS에 연결한 후 더이상 사용하지 않으면 연결을 해제해야 한다.
        rs.close();
        stmt.close();
        con.close();

    }
}

// JDBC 프로그래밍 개요 - JDBC 드라이버 타입과 준비
package step25.ex1;

import java.sql.DriverManager;

// JDBC 드라이버 다운로드
// 1) 
public class Exam01_4 {
    public static void main(String[] args) throws Exception {
        // 1) JDBC 드라이버 로딩
        // => 드라이버 객체를 생성하지 않고 클래스를 로딩하면
        //    자동으로 객체가 생성되어 DriverManager에 등록된다.
        Class.forName("com.mysql.cj.jdbc.Driver");

        // DriverManager에 자동 등록된 것을 확인해보자 !
        java.sql.Driver driver = DriverManager.getDriver("jdbc:mysql:");
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        // 해당 드라이버가 등록되지 않았으면 예외게 발생할 것이다. 
        
    }
}

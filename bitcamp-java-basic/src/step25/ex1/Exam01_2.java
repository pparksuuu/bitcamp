// JDBC 프로그래밍 개요 - JDBC 드라이버 타입과 준비
package step25.ex1;

import java.sql.DriverManager;

// JDBC 드라이버 다운로드
// 1) 
public class Exam01_2 {
    public static void main(String[] args) throws Exception {
        // 1) JDBC 드라이버 로딩
        // => java.sql.Driver 인터페이스 구현체를 만들어 
        //    Drivermanager가 찾을 수 잇도록 등록해야 한다.
        DriverManager.registerDriver(new com.mysql.jdbc.Driver());
        System.out.println("JDBC 드라이버 로딩 및 등록 완료!");
        
        // 위 mysql 드라이버는 구형 드라이버로서 사용하지 말도록 권고되고 있다.
    }
}

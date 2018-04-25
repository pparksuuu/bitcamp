package step25.ex4;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;

public class DataSource {
    String driver;
    String jdbcUrl;
    String user;
    String password;

    ArrayList<Connection> conPool = new ArrayList<>(); 

    public DataSource(String driver, String jdbcUrl,
            String user, String password) throws Exception {
        this.driver = driver;
        this.jdbcUrl = jdbcUrl;
        this.user = user;
        this.password = password;

        //JDBC 드라이버 로딩 및 DriverManager에 등록
        Class.forName(driver); 
        // Driver 클래스가 로딩도리 때 스스로 객체를 자동 생성하여 DriverManager에 등록할 것이다. 
    }

    public Connection getConnection() throws Exception {
        if (conPool.size() == 0) {
            // 저장된 커넥션 객체가 없다면, 새로 생성한다.
            System.out.println("새 연결 객체를 만든다.");
            return DriverManager.getConnection(jdbcUrl, user, password);
        }
        
        Connection con = conPool.remove(0);
        if (con.isClosed() || 
            !con.isValid(1)) {
            System.out.println("새 연결 객체를 만든다.");
            return DriverManager.getConnection(jdbcUrl, user, password);
        }
        
        System.out.println("기존 연결 객체를 사용한다.");
        return con;
    }
    
    public void returnConnection(Connection con) {
        conPool.add(con);
    }
}

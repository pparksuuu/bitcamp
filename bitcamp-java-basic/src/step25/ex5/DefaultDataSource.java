package step25.ex5;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Properties;

public class DefaultDataSource implements DataSource {
    String driver;
    String jdbcUrl;
    String user;
    String password;

    ArrayList<Connection> conPool = new ArrayList<>(); 

    // 생성자를 호출할 때 DB 관련 정보를 주지 않는다면,
    // JVM 프로퍼티에서 찾는다.
    public DefaultDataSource() throws Exception {
        Properties props = new Properties();
        props.load(new FileInputStream("jdbc.properties"));
        this.driver = props.getProperty("jdbc.driver");
        this.jdbcUrl = props.getProperty("jdbc.url");
        this.user = props.getProperty("jdbc.username");
        this.password = props.getProperty("jdbc.password");
    }
    
    public DefaultDataSource(String driver, String jdbcUrl,
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
            return new ConnectionProxy(
                    this,DriverManager.getConnection(jdbcUrl, user, password));
        }
        
        Connection con = conPool.remove(0);
        if (con.isClosed() || 
            !con.isValid(1)) {
            System.out.println("새 연결 객체를 만든다.");
            return new ConnectionProxy(
                    this,DriverManager.getConnection(jdbcUrl, user, password));
        }
        
        System.out.println("기존 연결 객체를 사용한다.");
        return con;
    }
    
    public void returnConnection(Connection con) {
        conPool.add(con);
    }
}

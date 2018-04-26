
package step25.ex5;

import java.sql.Connection;

public interface DataSource {
    Connection getConnection() throws Exception;
    void returnConnection(Connection con);
}

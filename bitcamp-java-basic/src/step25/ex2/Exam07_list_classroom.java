package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam07_list_classroom {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "select cno,titl,sdt,edt,rm from ex_classroom");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.printf("%s,%s,%s,%s,%s\n",
                    rs.getString("cno"),
                    rs.getString("titl"),
                    rs.getString("sdt"),
                    rs.getString("edt"),
                    rs.getString("rm")
                    );
        }
        
        rs.close();
        stmt.close();
        con.close();
    }
}

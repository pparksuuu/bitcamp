package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam06_list_teammember {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "select tnm,mid from ex_teammember");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.printf("%s,%s\n",
                    rs.getString("tnm"),
                    rs.getString("mid")
                    );
        }
        
        rs.close();
        stmt.close();
        con.close();
    }
}

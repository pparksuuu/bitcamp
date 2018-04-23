package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam03_list_member {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");

        PreparedStatement stmt = con.prepareStatement(
                "select id,em,pw from ex_member");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.printf("%s, %s, %s\n",
                    rs.getString("id"),
                    rs.getString("em"),
                    rs.getString("pw"));
        }

        rs.close();
        stmt.close();
        con.close();
    }
}

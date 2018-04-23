package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam04_list_team {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "select nm,dsc,mqt,sdt,edt from ex_team");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.printf("%s,%s,%d,%s,%s\n",
                    rs.getString("nm"),
                    rs.getString("dsc"),
                    rs.getInt("mqt"),
                    rs.getDate("sdt"),
                    rs.getDate("edt")
                    );
        }
        
        rs.close();
        stmt.close();
        con.close();
    }
}

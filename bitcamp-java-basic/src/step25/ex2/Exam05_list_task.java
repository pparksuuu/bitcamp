package step25.ex2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Exam05_list_task {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        Connection con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/java106db?serverTimezone=UTC&useSSL=false",
                "java106", "1111");
        
        PreparedStatement stmt = con.prepareStatement(
                "select tno,titl,sdt,edt,stt,tnm,mid from ex_task");

        ResultSet rs = stmt.executeQuery();
        while (rs.next()) {
            System.out.printf("%d,%s,%s,%s,%s,%s,%s\n",
                    rs.getInt("tno"),
                    rs.getString("titl"),
                    rs.getString("sdt"),
                    rs.getString("edt"),
                    rs.getString("stt"),
                    rs.getString("tnm"),
                    rs.getString("mid")
                    );
        }
        
        rs.close();
        stmt.close();
        con.close();
    }
}

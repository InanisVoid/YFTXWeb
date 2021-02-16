package Database;
import java.sql.*;

public class databaseConnect {
    Connection connect = null;
    public Connection dbConnect() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/yftx";
        connect = DriverManager.getConnection(url,"root","123456");
        return connect;
    }
}

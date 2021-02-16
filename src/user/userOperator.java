package user;
import Database.databaseConnect;
import java.sql.*;

public class userOperator {
    databaseConnect dbc = new databaseConnect();
    Statement statement = null;
    ResultSet resultSet = null;
    Connection connection = null;

    public void insert(user user) {
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql1 = "replace into user values(?,?)";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, user.getUserID());
            ps.setString(2, user.getUserNickname());
            ps.execute();

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (statement != null) {
                    statement.close();
                    resultSet = null;
                }
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }

    public user selectUserByUserID(int Userid){

        user user = new user();
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql = "select * from user where UserID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, Userid);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                user.setUserID(Userid);
                user.setUserNickname(resultSet.getString("UserNickname"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                if (resultSet != null) {
                    resultSet.close();
                    resultSet = null;
                }
                if (statement != null) {
                    statement.close();
                    resultSet = null;
                }
                if (connection != null) {
                    connection.close();
                    connection = null;
                }
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return user;
    }
}
package Database;

import java.sql.*;

public class userInfoOperator {
    databaseConnect dbc = new databaseConnect();
    Statement statement = null;
    ResultSet resultSet = null;
    Connection connection = null;

    public void insert(userInfo userInfo) {
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql1 = "insert into userinfo values(null,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, userInfo.getUserID());
            ps.setString(2, userInfo.getNickname());
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

    public userInfo selectUserByUserID(int userid){
        int id;
        String userNickname=null;
        userInfo user = new userInfo();
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql = "select * from userinfo where userid = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, userid);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {

                user.setID(resultSet.getInt("id"));
                user.setUserID(userid);
                user.setNickname(resultSet.getString("nickname"));

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

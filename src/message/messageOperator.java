package message;

import Database.databaseConnect;

import java.sql.*;
import java.util.*;
public class messageOperator {
    databaseConnect dbc = new databaseConnect();
    Statement statement = null;
    ResultSet resultSet = null;
    Connection connection = null;

    public void insert(message message) {
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql1 = "insert into message values(null,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, message.getRoomID());
            ps.setInt(2, message.getUserID());
            ps.setString(3, message.getUserNickname());
            ps.setString(4, message.getContent());
            ps.setString(5, message.getTime());

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

    public Vector<message> selectHistoryByRoomID(int RoomID){
        Vector<message> history=new Vector<message>();
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql = "select * from message where RoomID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, RoomID);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                message message=new message();
                message.setMessageID(resultSet.getInt("MessageID"));
                message.setUserID(resultSet.getInt("UserID"));
                message.setRoomID(resultSet.getInt("RoomID"));
                message.setUserNickname(resultSet.getString("UserNickname"));
                message.setContent(resultSet.getString("Content"));
                message.setTime(resultSet.getString("Time"));
                history.addElement(message);
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
        return history;
    }
}

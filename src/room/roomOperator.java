package room;
import Database.databaseConnect;

import java.sql.*;

public class roomOperator {
    databaseConnect dbc = new databaseConnect();
    Statement statement = null;
    ResultSet resultSet = null;
    Connection connection = null;

    public void insert(room room) {
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql1 = "insert into room values(null,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, room.getMemberNum());
            ps.setDouble(2, room.getDepartureLon());
            ps.setDouble(3, room.getDepartureLat());
            ps.setDouble(4, room.getDestinationLon());
            ps.setDouble(5, room.getDestinationLat());
            ps.setString(6, room.getDeparture());
            ps.setString(7, room.getDestination());
            ps.setString(8, room.getTime());
//            ps.setString(9, room.getMember());
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

    public void updateRoomInfo(room room){
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql1 = "replace into room values(?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, room.getRoomID());
            ps.setInt(2, room.getMemberNum());
            ps.setDouble(3, room.getDepartureLon());
            ps.setDouble(4, room.getDepartureLat());
            ps.setDouble(5, room.getDestinationLon());
            ps.setDouble(6, room.getDestinationLat());
            ps.setString(7, room.getDeparture());
            ps.setString(8, room.getDestination());
            ps.setString(9, room.getTime());
//            ps.setString(19, room.getMember());
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



    public room selectRoomByRoomID(int RoomID){
        room room = new room();
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql = "select * from room where RoomID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, RoomID);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                room.setRoomID(RoomID);
                room.setMemberNum(resultSet.getInt("MemberNum"));
                room.setDepartureLon(resultSet.getDouble("DepartureLon"));
                room.setDepartureLat(resultSet.getDouble("DepartureLon"));
                room.setDestinationLon(resultSet.getDouble("DestinationLon"));
                room.setDestinationLat(resultSet.getDouble("DestinationLat"));
                room.setDeparture(resultSet.getString("Departure"));
                room.setDestination(resultSet.getString("Destination"));
//                room.setMember(resultSet.getString("Member"));
                room.setTime(resultSet.getString("Time"));
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
        return room;
    }
}
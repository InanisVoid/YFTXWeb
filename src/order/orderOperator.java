package order;
import Database.databaseConnect;

import java.sql.*;
public class orderOperator {
    databaseConnect dbc = new databaseConnect();
    Statement statement = null;
    ResultSet resultSet = null;
    Connection connection = null;

    public void insert(order order) {
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql1 = "insert into orders values(null,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, order.getUserID());
            ps.setString(2, order.getTime());
            ps.setDouble(3, order.getDepartureLon());
            ps.setDouble(4, order.getDepartureLat());
            ps.setDouble(5, order.getDestinationLon());
            ps.setDouble(6, order.getDestinationLat());
            ps.setString(7, order.getDeparture());
            ps.setString(8, order.getDestination());
            ps.setInt(9, order.getRoomID());
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

    public order selectOrderByOrderID(int OrderID){
        order order = new order();
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql = "select * from orders where OrderID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, OrderID);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                order.setOrderID(OrderID);
                order.setDepartureLon(resultSet.getDouble("DepartureLon"));
                order.setDepartureLat(resultSet.getDouble("DepartureLon"));
                order.setDestinationLon(resultSet.getDouble("DestinationLon"));
                order.setDestinationLat(resultSet.getDouble("DestinationLat"));
                order.setDeparture(resultSet.getString("Departure"));
                order.setDestination(resultSet.getString("Destination"));
                order.setTime(resultSet.getString("Time"));
                order.setRoomID(resultSet.getInt("RoomID"));
                order.setUserID(resultSet.getInt("UserID"));
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
        return order;
    }
}

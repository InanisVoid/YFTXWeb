package orders;
import Database.databaseConnect;

import java.sql.*;
import java.util.Vector;

public class orderOperator {
    databaseConnect dbc = new databaseConnect();
    Statement statement = null;
    ResultSet resultSet = null;
    Connection connection = null;

    public void insert(orders orders) {
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql1 = "insert into orders values(null,?,?,?,?,?,?,?,?,?)";
            PreparedStatement ps = connection.prepareStatement(sql1);
            ps.setInt(1, orders.getUserID());
            ps.setString(2, orders.getTime());
            ps.setDouble(3, orders.getDepartureLon());
            ps.setDouble(4, orders.getDepartureLat());
            ps.setDouble(5, orders.getDestinationLon());
            ps.setDouble(6, orders.getDestinationLat());
            ps.setString(7, orders.getDeparture());
            ps.setString(8, orders.getDestination());
            ps.setInt(9, orders.getRoomID());
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

    public orders selectOrderByOrderID(int OrderID){
        orders orders = new orders();
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql = "select * from orders where OrderID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, OrderID);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                orders.setOrderID(OrderID);
                orders.setDepartureLon(resultSet.getDouble("DepartureLon"));
                orders.setDepartureLat(resultSet.getDouble("DepartureLat"));
                orders.setDestinationLon(resultSet.getDouble("DestinationLon"));
                orders.setDestinationLat(resultSet.getDouble("DestinationLat"));
                orders.setDeparture(resultSet.getString("Departure"));
                orders.setDestination(resultSet.getString("Destination"));
                orders.setTime(resultSet.getString("Time"));
                orders.setRoomID(resultSet.getInt("RoomID"));
                orders.setUserID(resultSet.getInt("UserID"));
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
        return orders;
    }

    public Vector<orders> selectOrderByUserID(int UserID){
        Vector<orders> allOrder=new Vector<orders>();
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql = "select * from orders where UserID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, UserID);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                orders orders=new orders();
                orders.setOrderID(resultSet.getInt("OrderID"));
                orders.setDepartureLon(resultSet.getDouble("DepartureLon"));
                orders.setDepartureLat(resultSet.getDouble("DepartureLat"));
                orders.setDestinationLon(resultSet.getDouble("DestinationLon"));
                orders.setDestinationLat(resultSet.getDouble("DestinationLat"));
                orders.setDeparture(resultSet.getString("Departure"));
                orders.setDestination(resultSet.getString("Destination"));
                orders.setTime(resultSet.getString("Time"));
                orders.setRoomID(resultSet.getInt("RoomID"));
                orders.setUserID(resultSet.getInt("UserID"));
                allOrder.addElement(orders);
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
        return allOrder;
    }

    public Vector<orders> selectOrderByRoomID(int RoomID){
        Vector<orders> allOrder=new Vector<orders>();
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            String sql = "select * from orders where RoomID = ?";
            PreparedStatement ps = connection.prepareStatement(sql);
            ps.setInt(1, RoomID);
            resultSet = ps.executeQuery();
            while (resultSet.next()) {
                orders orders=new orders();
                orders.setOrderID(resultSet.getInt("OrderID"));
                orders.setDepartureLon(resultSet.getDouble("DepartureLon"));
                orders.setDepartureLat(resultSet.getDouble("DepartureLat"));
                orders.setDestinationLon(resultSet.getDouble("DestinationLon"));
                orders.setDestinationLat(resultSet.getDouble("DestinationLat"));
                orders.setDeparture(resultSet.getString("Departure"));
                orders.setDestination(resultSet.getString("Destination"));
                orders.setTime(resultSet.getString("Time"));
                orders.setRoomID(resultSet.getInt("RoomID"));
                orders.setUserID(resultSet.getInt("UserID"));
                allOrder.addElement(orders);
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
        return allOrder;
    }
}

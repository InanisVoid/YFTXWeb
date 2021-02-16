package Database;
import java.sql.*;
import user.*;
import room.*;
import order.*;
import message.*;
import java.util.Vector;
public class databaseTest {
    static databaseConnect dbc=new databaseConnect();
    static Statement statement=null;
    static ResultSet resultSet=null;
    static Connection connection=null;
    public static void databacetest() {
        try {
            connection = dbc.dbConnect();
            Statement statement = connection.createStatement();
            resultSet = statement.executeQuery("select * from userinfo");
            while (resultSet.next()) {

                System.out.println(resultSet.getString("nickname"));

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
    }

    public static void main(String[] args) {
        databacetest();
//        userOperator uop=new userOperator();
//        user uif=new user(3,"ZJZ");
//        uop.insert(uif);
//        System.out.println(uop.selectUserByUserID(1).getUserNickname());
        roomOperator rop=new roomOperator();
        room room=new room(0,2, 113.332264,23.156206,113.332264,23.156206,"A","B","1");
        rop.insert(room);
//        rop.insert(room);
//        rop.insert(room);
        int temp=rop.selectRoomByPosition(113.332264,23.156206,113.332264,23.156206).getRoomID();
        System.out.println(temp);
//        orderOperator oop=new orderOperator();
//        order order=new order(0,1,"T",1.1,1.2,1.3,1.4,"A","B",1);
//        oop.insert(order);
//        oop.insert(order);
//        oop.insert(order);

//        System.out.println(oop.selectOrderByOrderID(2).getRoomID());
//        messageOperator mop = new messageOperator();
//        message m1=new message(0,1,1,"ZJZ","A","1");
//        message m2=new message(0,1,2,"WZH","B","1");
//        mop.insert(m1);
//        mop.insert(m2);
//        Vector<message> h=mop.selectHistoryByRoomID(1);
//        for (message m:h){
//            System.out.println(m.getContent());
//        }
    }

}

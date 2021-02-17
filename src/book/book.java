package book;

//package userInfo;
//import Database.userInfo;
//import Database.userInfoOperator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import orders.orders;
import orders.orderOperator;
import room.room;
import room.roomOperator;
import tools.LocationUtil;

import java.io.IOException;

@WebServlet(name="book")
public class book extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        int UserID=Integer.parseInt(request.getParameter("UserID"));
        String Time=request.getParameter("Time");
        double DepartureLon =Double.parseDouble(request.getParameter("DepartureLon"));
        double DepartureLat =Double.parseDouble(request.getParameter("DepartureLat"));
        double DestinationLon =Double.parseDouble(request.getParameter("DestinationLon"));
        double DestinationLat =Double.parseDouble(request.getParameter("DestinationLat"));

        String Departure = LocationUtil.getPosition(DepartureLon,DepartureLat);
        String Destination = LocationUtil.getPosition(DestinationLon,DestinationLat);

        roomOperator rop=new roomOperator();
        room rTemp=rop.selectRoomByPosition(DepartureLon,DepartureLat,DestinationLon,DestinationLat);
        if (rTemp.getRoomID()==0){
            rop.insert(rTemp);
            rTemp=rop.selectRoomByPosition(DepartureLon,DepartureLat,DestinationLon,DestinationLat);
        }

        orderOperator db = new orderOperator();
        orders uio=new orders(0,UserID,Time,DepartureLon,DepartureLat,DestinationLon,DestinationLat,Departure,Destination,rTemp.getRoomID());

//        JSONObject json=new JSONObject();
//        db.insert(uio);
//        json.put("userID",userID);
//        json.put("nickName", nickname);
//        json.put("message", "Success");
//
//
//        //返回值给微信小程序
//        Writer out = response.getWriter();
//        out.write(String.valueOf(json));
//        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

package chatroom;


import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import message.messageOperator;
import message.message;
import net.sf.json.JSON;
import net.sf.json.JSONArray;
import net.sf.json.JSONObject;
import orders.orderOperator;
import orders.orders;
import room.roomOperator;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Vector;

@WebServlet(name="chatroom")
public class chatroom extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        int RoomID=Integer.parseInt(request.getParameter("RoomID"));


        messageOperator mop=new messageOperator();

        Vector<message> relateMessages= mop.selectHistoryByRoomID(RoomID);

        Vector<JSONObject> history=new Vector<JSONObject>();
        for (message m:relateMessages){
            JSONObject temp=new JSONObject();
            temp.put("Time",m.getTime());
            temp.put("UserID",m.getUserID());
            temp.put("UserNickname",m.getUserNickname());
            temp.put("Content",m.getContent());
            history.add(temp);
        }
        JSONArray json=JSONArray.fromObject(history);



        //返回值给微信小程序
        Writer out = response.getWriter();
        out.write(String.valueOf(json));
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
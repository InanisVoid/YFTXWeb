package order;

import Database.userInfo;
import Database.userInfoOperator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import net.sf.json.JSONArray;
import orders.orders;

import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;
import java.util.Vector;
import orders.orderOperator;
@WebServlet(name="order")
public class order extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        int UserID=Integer.parseInt(request.getParameter("UserID"));
        Vector<orders>  allOrder= new Vector<orders>();

        orderOperator db=new orderOperator();
        allOrder = db.selectOrderByUserID(UserID);
        JSONArray json= JSONArray.fromObject(allOrder);



        //返回值给微信小程序
        Writer out = response.getWriter();
        out.write(String.valueOf(json));
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}
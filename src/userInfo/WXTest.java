package userInfo;
import Database.userInfo;
import Database.userInfoOperator;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name="WXTest")
public class WXTest extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        int userID=Integer.parseInt(request.getParameter("userid"));
        String nickname=request.getParameter("nickname");

        userInfoOperator db = new userInfoOperator();
        userInfo uio=new userInfo(0,userID,nickname);
        JSONObject json=new JSONObject();
        db.insert(uio);
        json.put("userID",userID);
        json.put("nickName", nickname);
        json.put("message", "Success");


        //返回值给微信小程序
        Writer out = response.getWriter();
        out.write(String.valueOf(json));
        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

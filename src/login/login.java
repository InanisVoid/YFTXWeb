package login;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import net.sf.json.JSONObject;
import user.user;
import user.userOperator;


import java.io.IOException;
import java.io.PrintWriter;
import java.io.Writer;

@WebServlet(name="login")
public class login extends HttpServlet{
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setContentType("text/html;charset=utf-8");
        response.setHeader("Access-Control-Allow-Origin", "*");
        response.setHeader("Access-Control-Allow-Methods", "GET,POST");

        int userID=Integer.parseInt(request.getParameter("UserID"));
        String nickname=request.getParameter("UserNickname");

        userOperator db = new userOperator();
        user newUser=new user(userID,nickname);
        db.insert(newUser);
//        JSONObject json=new JSONObject();

//        json.put("userID",userID);
//        json.put("nickName", nickname);
//        json.put("message", "Success");

        //返回值给微信小程序
//        Writer out = response.getWriter();
//        out.write(String.valueOf(json));
//        out.flush();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }
}

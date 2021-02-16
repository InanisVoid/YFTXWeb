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

@WebServlet(name="GetUserInfo")
public class GetUserInfo extends HttpServlet{
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        super.doPost(req, resp);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        response.setCharacterEncoding("utf-8");
        int userID=Integer.parseInt(request.getParameter("useridGet"));
//        System.out.println(userID);

//        System.out.println(nickname);

        userInfoOperator db = new userInfoOperator();
        userInfo uio=db.selectUserByUserID(userID);
        String nickname=uio.getNickname();
        JSONObject json=new JSONObject();

        db.insert(uio);

        json.put("userID",userID);
        json.put("nickName", nickname);
        json.put("message", "Success");

        PrintWriter out = response.getWriter();
        out.println(json);
    }
}

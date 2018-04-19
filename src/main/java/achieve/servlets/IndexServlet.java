package achieve.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class IndexServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html;charset=utf-8");
//        PrintWriter writer = response.getWriter();

        String html = "";

        //得到session对象
        HttpSession session = request.getSession(false);
        if(session==null){
            //没有登录成功，跳转到登录页面
            response.sendRedirect(request.getContextPath()+"user/login.jsp");
            return;
        }

        //取出会话数据
        String loginName = (String)session.getAttribute("loginName");
        if(loginName==null){
            //没有登录成功，跳转到登录页面
            response.sendRedirect(request.getContextPath()+"/servlets.html");
            return;
        }

//        html = "<html><body>欢迎回来，" +loginName+ "</a></body></html>";
//
//
//        writer.write(html);
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }

}

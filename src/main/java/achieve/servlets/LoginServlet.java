package achieve.servlets;

import achieve.dao.UserDaoImpl;
import achieve.pojo.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        request.setCharacterEncoding("utf-8");

        //接收参数
        String userName = request.getParameter("userName");
        String userPwd = request.getParameter("userPwd");

        User user = new UserDaoImpl().findByUserName(userName);

        if(user != null && user.getPassword().equals(userPwd)){
            //登陆成功

            //创建session对象
            HttpSession session = request.getSession();
            //把用户数据保存在session域对象中
            session.setAttribute("loginName", user.getRealName());
            session.setAttribute("userId", user.getId());
            session.setAttribute("currentUser", user);
            //跳转到用户主页
            response.sendRedirect(request.getContextPath()+"/home/index");
        } else {
            //登陆失败，请求重定向
            response.sendRedirect(request.getContextPath() + "/user/login");
        }

        //判断登陆是否成功
//        if(userName.equals("admin") && userPwd.equals("123456")) {
//            //登陆成功
//
//            //创建session对象
//            HttpSession session = request.getSession();
//            //把用户数据保存在session域对象中
//            session.setAttribute("loginName", userName);
//            //跳转到用户主页
//            response.sendRedirect(request.getContextPath()+"/home/index");
//        } else {
//            //登陆失败，请求重定向
//            response.sendRedirect(request.getContextPath() + "/user/login");
//        }


    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        doGet(request, response);
    }



}

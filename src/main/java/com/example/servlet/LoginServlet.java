package com.example.servlet;
import com.example.Users;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/login")
public class LoginServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        if(session==null || session.getAttribute("user")==null){
            response.sendRedirect(request.getContextPath()+"/login.jsp");
        }
        else{
            response.sendRedirect(request.getContextPath()+"/user/hello.jsp");
        }
    }
    protected void doPost(HttpServletResponse response, HttpServletRequest request) throws IOException, ServletException {
        String login = request.getParameter("username");
        String password = request.getParameter("password");
        if(isValidLogin(login,password)){
            HttpSession session = request.getSession();
            session.setAttribute("user",login);
            response.sendRedirect(request.getContextPath() + "/user/hello.jsp");
        }
        else{
            request.setAttribute("error","Invalid Login or User does not exist");
            request.getRequestDispatcher("/login.jsp").forward(request,response);
        }
    }
    private boolean isValidLogin(String login, String password){
        Users users = Users.getInstance();

        return users.getUsers().contains(login) && password!=null && !password.isEmpty();
    }
}

package com.example.servlet;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet("/logout")
public class LogoutServlet {
    protected void doGet(HttpServletRequest request,HttpServletResponse response) throws IOException{
        HttpSession session = request.getSession(false);
        //delete attr && session if Exists
        if(session!=null){
            session.removeAttribute("user");
            session.invalidate();
        }
        response.sendRedirect(request.getContextPath()+"/login.jsp");

    }
}

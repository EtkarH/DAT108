package com.obl3oppg1;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

@WebServlet(name="LoginServlet",urlPatterns={"/login"})
public class LoginServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String message = "<p>Skriv inn passord: </p>";
        HttpSession sesjon = request.getSession(false);

        if (sesjon != null && sesjon.getAttribute("username") != null){
            if (sesjon != null && !sesjon.getAttribute("username").toString().equalsIgnoreCase("admin")){
                message = "<p style=\"color:red\">Passordet du ga inn var feil. Prøv igjen: </p>";
            } else if (sesjon.getAttribute("username").toString().equalsIgnoreCase("admin")){
                response.sendRedirect("handle");
            } else {
                message = "<p>Skriv inn passord: </p>";
            }
        }

        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Login side</title>");
        out.println("</head>");
        out.println("<body>");

        out.println("<p>" + message + "</p>");
        out.println("<form action=\"login\" method=\"post\">");
        out.println("<p><input type=\"text\" name=\"username\" /></p>");
        out.println("<p><input type=\"submit\" value=\"Logg inn\" /></p>");
        out.println("</form>");

        out.println("<h1>" + "</h1>");
        out.println("</body>");
        out.println("</html>");

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        HttpSession sesjon = request.getSession(true);
        String username = request.getParameter("username");

        if (!username.equalsIgnoreCase("admin") || username == null){
            sesjon.setAttribute("username", username);
            response.sendRedirect("login");
        } else {
            sesjon.setAttribute("username", username);
            sesjon.setAttribute("cart", new ArrayList<String>());
            sesjon.setMaxInactiveInterval(60); // 60 sekunder
            response.sendRedirect("handle");
        }








    }
}

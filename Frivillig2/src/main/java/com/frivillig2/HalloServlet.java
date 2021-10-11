package com.frivillig2;
import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name="HalloServlet",urlPatterns={"/hallo"})
public class HalloServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Temp results</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<h1>Hei, " + request.getParameter("navn") + "!</h1>");
        out.println("</body>");
        out.println("</html>");

    }
}

package com.obl3oppg1;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name="HandleServlet",urlPatterns={"/handle"})
public class HandleServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        HttpSession sesjon = request.getSession(false);
        if (sesjon != null && sesjon.getAttribute("username") != null){
            PrintWriter out = response.getWriter();
            out.println("<!DOCTYPE html>");
            out.println("<html>");
            out.println("<head>");
            out.println("<meta charset=\"UTF-8\">");
            out.println("<title>Handleside</title>");
            out.println("</head>");
            out.println("<body>");
            out.println("<h1>Min handleliste</h1>");
            out.println("<form action=\"handle\" method=\"post\">");
            out.println("<p><input type=\"submit\" value=\"Legg til\" />   <input type=\"text\" name=\"item\" /></p>");
            out.println("</form>");

            if (sesjon.getAttribute("cart") != null){
                List<String> items = (ArrayList<String>) sesjon.getAttribute("cart");
                out.println("<form action=\"handle\" method=\"post\">");
                for (String i : items){
                    out.println("<p><button name=\"delete\" type=\"submit\" value=\"" + i +"\">Slett</button>   " + i+"</p>");
                }
                out.println("</form>");

            }

            out.println("</body>");
            out.println("</html>");
        } else {
            response.sendRedirect("login");
        }


    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession sesjon = request.getSession(false);
        if (sesjon != null && sesjon.getAttribute("username") != null){
            List<String> items = (ArrayList<String>) sesjon.getAttribute("cart");
            if (request.getParameter("delete") != null){
                items.removeIf(a -> request.getParameter("delete").equalsIgnoreCase(a));
                sesjon.setAttribute("cart",items);
                response.sendRedirect("handle");
            } else if (request.getParameter("item") != null && Validator.isGyldigUsername(request.getParameter("item"))){
                items.add(request.getParameter("item"));
                sesjon.setAttribute("cart",items);
                response.sendRedirect("handle");

            } else {
                response.sendRedirect("handle");
            }
        } else {
            response.sendRedirect("login");
        }


    }


    }
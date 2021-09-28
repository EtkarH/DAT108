package com.example;

import java.io.*;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="KongeServlet",urlPatterns={"/sok"})
public class KongeServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        int aar = Integer.parseInt(request.getParameter("aar"));
        List<Konge> konger = new Konger().getNorske();
        Konge konge = konger.stream().filter(a -> a.getKongeFraAar() <= aar && a.getKongeTilAar() > aar).collect(Collectors.toList()).get(0);
        response.setContentType("text/html; charset=ISO-8859-1");

        // Hello
        PrintWriter out = response.getWriter();

        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"ISO-8859-1\">");
        out.println("<title>Konge</title>");
        out.println("</head>");
        out.println("<body>");
        out.println("<img src=\""+ konge.getBilde() + "\" width=\"400\" height=\"500\">");
        out.println("<h1>" + "Konge i år "+ aar + " var " + konge.getNavn() + ", født " + konge.getFodtAar() + ", konge fra " + konge.getKongeFraAar() + " til " + konge.getKongeTilAar() + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

}
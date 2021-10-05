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

        String res = request.getParameter("aar");

        List<Konge> konger = new Konger().getNorske();


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
        if (res.matches("^\\d{4}$") || res != null){
            int aar = Integer.parseInt(res);
            if (aar < 1448 || aar >= 1588) {
                out.println("<h1>Kongen for dette året er ikke registrert.</h1>");
            }
            else {
                Konge konge = konger.stream().filter(a -> a.getKongeFraAar() <= aar && a.getKongeTilAar() > aar).collect(Collectors.toList()).get(0);
                out.println("<img src=\""+ konge.getBilde() + "\" width=\"400\" height=\"500\">");
                out.println("<h1>" + "Konge i år "+ aar + " var " + konge.getNavn() + ", født " + konge.getFodtAar() + ", konge fra " + konge.getKongeFraAar() + " til " + konge.getKongeTilAar() + "</h1>");
            }
        } else {
            out.println("<h1>Ugyldig input</h1>");
        }

        out.println("</body>");
        out.println("</html>");
    }

}
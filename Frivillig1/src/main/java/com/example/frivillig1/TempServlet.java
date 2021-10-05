package com.example.frivillig1;

import java.io.*;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name="TempServlet",urlPatterns={"/convert"})
public class TempServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html; charset=UTF-8");

        String input = request.getParameter("temp");
        String typeString = request.getParameter("convertType");

        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Temp results</title>");
        out.println("</head>");
        out.println("<body>");

        if (validInput(input)){
            double temp = Double.parseDouble(input);

            if (typeString.equals("ToFahrenheit")){

                if (temp >= -273.15){
                    double toFahrenheit = (temp * 9/5) + 32;

                    out.println("<h1>" + temp + "°C = " + String.format("%.1f",toFahrenheit) + "°F" + "</h1>");

                } else {
                    out.println("<h1>Can't go lower!</h1>");
                }


            } else {

                if (temp >= -459.67){
                    double toCelsius = (temp - 32) * 5/9;
                    out.println("<h1>" + temp + "°F = " + String.format("%.1f",toCelsius) + "°C" + "</h1>");
                } else {
                    out.println("<h1>Can't go lower!</h1>");
                }

            }

        } else {
            out.println("<h1>Invalid input!</h1>");
        }

        out.println("<h1>" + "</h1>");
        out.println("</body>");
        out.println("</html>");
    }

    public boolean validInput(String s){
        
        if (s != null || s != ""){

            return s.matches("^[+-]?([0-9]+\\.?[0-9]*|\\.[0-9]+)$");

        } else {
            return false;
        }

    }

}
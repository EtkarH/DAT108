package com.frivillig3.frivillig3;

import java.io.*;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.stream.Collectors;
import java.util.stream.Stream;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name="FruitServlet",urlPatterns={"/fruit"})
public class FruitServlet extends HttpServlet {

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html; charset=UTF-8");

        // Hello
        PrintWriter out = response.getWriter();
        out.println("<!DOCTYPE html>");
        out.println("<html>");
        out.println("<head>");
        out.println("<meta charset=\"UTF-8\">");
        out.println("<title>Fruit results</title>");
        out.println("</head>");
        out.println("<body>");

        if (request.getParameter("fruitType") != null){

            if (request.getCookies() != null){
                Cookie[] cookies = request.getCookies();
                String fruit = request.getParameter("fruitType");

                Stream.of(cookies).filter(a -> a.getName().equals(fruit)).forEach(a -> a.setValue(Integer.toString(Integer.parseInt(a.getValue()) + 1)));
                Cookie cookie = Stream.of(cookies).filter(a -> a.getName().equals(fruit)).collect(Collectors.toList()).get(0);
                response.addCookie(cookie);

                String appleNum = Stream.of(cookies).filter(a -> a.getName().equals("apple")).findFirst().orElse(null).getValue();
                String orangeNum = Stream.of(cookies).filter(a -> a.getName().equals("orange")).findFirst().orElse(null).getValue();
                String bananaNum = Stream.of(cookies).filter(a -> a.getName().equals("banana")).findFirst().orElse(null).getValue();
                out.println("<h1>Fruit results</h1>");

                out.println("<p>Apple: " + appleNum + "</p>");
                out.println("<p>Orange: " +orangeNum + "</p>");
                out.println("<p>Banana: " + bananaNum + "</p>");

            } else {
                int number = 0;
                String fruit = request.getParameter("fruitType");
                Cookie apple = new Cookie("apple", "0");
                Cookie orange = new Cookie("orange","0");
                Cookie banana = new Cookie("banana", "0");


                 if (fruit.equals("apple")){
                     number = Integer.parseInt(apple.getValue())+1;
                     apple.setValue(Integer.toString(number));
                 } else if (fruit.equals("orange")){
                     number = Integer.parseInt(orange.getValue())+1;
                     orange.setValue(Integer.toString(number));
                 } else {
                     number = Integer.parseInt(banana.getValue())+1;
                     banana.setValue(Integer.toString(number));
                 }

                 apple.setMaxAge(300);
                orange.setMaxAge(300);
                banana.setMaxAge(300);
                 response.addCookie(apple);
                response.addCookie(orange);
                response.addCookie(banana);

                out.println("<h1>Fruit results</h1>");
                out.println("<p>Apple: " + apple.getValue() +"</p>");
                out.println("<p>Orange: " + orange.getValue() +"</p>");
                out.println("<p>Banana: " + banana.getValue() +"</p>");

            }

        } else {
            out.println("<h1>ERROR! Velg en frukt!</h1>");
        }
        out.println("<br /><a href=\"index.html\">Do it again</a>");
        out.println("</body></html>");
    }

}
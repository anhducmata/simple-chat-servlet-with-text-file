/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mata
 */
public class room extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        
        String encoding = resp.getCharacterEncoding();
            if ((encoding != null) && (encoding.equalsIgnoreCase("utf-8")))
            {
                resp.setContentType("text/html; charset=utf-8");
            }
        PrintWriter out = resp.getWriter();
        String[] room_list = new String[] {"adult", "man", "women","teen", "anonymous", "datting"};
        String room_name = req.getParameter("room");
        if(Arrays.asList(room_list).contains(room_name)){
            String file_name="G:\\Project\\ChatRoom\\ChatRoom\\room\\"+ room_name +".txt";      
            System.out.println(file_name);
            Readfile file=new Readfile(file_name);
            String[] aryLines=file.OpenFile();
            HttpSession session=req.getSession(false);  
            String username=(String)session.getAttribute("username");
            String adult = "adult"; 
            if (session.getAttribute("username") != null) {
                // *CHECK ADULT
                if ((!checkAdult((String) session.getAttribute("username")) && Objects.equals(room_name, adult)) || (!checkSingle((String) session.getAttribute("status")) && Objects.equals(room_name, "datting"))) {
                    // false => redirect home page
                    resp.sendRedirect("home");
                }else{ //else show Room
                        int i = 0;
                        out.println("<html> <head> <meta charset=\"utf-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <script src=\"js/jquery.min.js\" type=\"text/javascript\"></script> <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script> <link href=\"./css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\"/> <link href=\"./css/bootstrapCustom.css\" rel=\"stylesheet\" type=\"text/css\"/> <style> .chat-message{ border: 1px solid #ccc; padding: 10px; overflow-y:scroll;\n" + "\n" + "} </style> <script> function scroll() { $(\".chat-message\").animate({ scrollTop: $(\".chat-message\")[0].scrollHeisght }, \"slow\"); return true; } </script> </head> <body onload=\"scroll()\"> <div class=\"navbar navbar-default\"> <div class=\"container\"> <div class=\"navbar-header\"> <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar-ex-collapse\"> <span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span><span class=\"icon-bar\"></span> </button> <a class=\"navbar-brand\" href=\"index\"><span><b>MatChat</b></span></a> </div> <div class=\"collapse navbar-collapse\" id=\"navbar-ex-collapse\"> <ul class=\"nav navbar-nav navbar-right\"> <li class=\"active\"><a href=\"home\"><img style=\"width: 25px; height: 25px; margin-right: 10px;\" src=\"images/"+ getAvatar(username) +".png\" alt=\"User Avatar\">"+ session.getAttribute("username")+"</a> </li> <li> <a href=\"logout\">Logout</a> </li> </ul> </div> </div> </div> <div class=\"container\" style=\"margin-top: 30px;\"> <a href=\"home\" class=\"btn btn-primary btn-success\" style=\"margin-bottom: 10px\"><span class=\"glyphicon glyphicon-chevron-left\" ></span> Back</a> <div class=\"col-md-12 bg-white \"> <div class=\"chat-message\" style=\"overflow-y: scroll; max-height: 500px;\"> <ul class=\"chat\" >");
                        //Message Loop
                        while (i < aryLines.length ) {
                            String[] array = aryLines[i].split("\\|", -1); //split data include by |
                            String avatar = "";
                            if (Objects.equals(room_name, "anonymous")) {
                                avatar = "image2";
                            }else{
                                avatar = getAvatar(array[0]);
                            }
                            out.println(" <li class=\"left clearfix\"> <span class=\"chat-img pull-left\"> <img src=\"images/"+ avatar +".png\" alt=\"User Avatar\"> </span> <div class=\"chat-body clearfix\"> <div class=\"header\"> <strong class=\"primary-font\">"+ array[0] +"</strong> <small class=\"pull-right text-muted\"><i class=\"fa fa-clock-o\"></i> " + array[2] + "</small> </div> <p> "+ array[1] +" </p> </div> </li>");
                            i++;            
                        }
                        //end Loop
                    out.println(" </ul> </div> <form action=\"chat\" method=\"post\"> <div class=\"chat-box bg-white\"> <div class=\"input-group\"> <input id=\"room-mess\" name=\"room\" hidden value=\""+ room_name +"\" /> <input class=\"form-control border no-shadow no-rounded\" name=\"message\" placeholder=\"Type a message...\" autofocus > <span class=\"input-group-btn\"> <button class=\"btn btn-success no-rounded\" type=\"submit\">Send</button> </span> </div> </div> </form> </div> </div></body> </html>");
                    }
            }else{ //  Is not Login redirect to Login page
                resp.sendRedirect("login");
            }
        }else{
            resp.sendRedirect("404.html");
        }
    }
    String getAvatar(String username) throws IOException{
        String file_name="G:\\Project\\ChatRoom\\ChatRoom\\user.txt";      
        System.out.println(file_name);
        Readfile file=new Readfile(file_name);
        String[] aryLines=file.OpenFile();
        int i = 0;
        while (i < aryLines.length ) {
            String[] array = aryLines[i].split("\\|", -1); //split data include by |
            if (Objects.equals(username, array[1])) {
                return array[6];
            }
            i++;            
        }
        return null;
    }
    private boolean checkAdult(String session) throws IOException{
        String file_name="G:\\Project\\ChatRoom\\ChatRoom\\user.txt";      
        Readfile file=new Readfile(file_name);
        String[] aryLines;
        aryLines = file.OpenFile();
        int i = 0;
        while (i < aryLines.length ) {
            String[] array = aryLines[i].split("\\|", -1);
            int age = Integer.parseInt(array[5]);
            if (Objects.equals(array[1], session)) {
                if (age >= 18) {
                    return true;
                }
            }
            i++;
        }
        return false;
    }
    private boolean checkSingle(String status){
        return Objects.equals(status, "single");
    }
}

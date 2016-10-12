/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mata
 */
public class index extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        PrintWriter out=resp.getWriter();  
        if (session.getAttribute("username") == null) {
            
            out.println("<html> <head> <meta charset=\"utf-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <script src=\"js/jquery.min.js\" type=\"text/javascript\"></script> <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script> <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\"/> <link href=\"css/bootstrapCustom.css\" rel=\"stylesheet\" type=\"text/css\"/> </head> <body> <div class=\"cover\"> <div class=\"navbar navbar-default\"> <div class=\"container\"> <div class=\"navbar-header\"> <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar-ex-collapse\"> <span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span><span class=\"icon-bar\"></span> </button> <a class=\"navbar-brand\" href=\"index\"><span><b>MatChat</b></span></a> </div> <div class=\"collapse navbar-collapse\" id=\"navbar-ex-collapse\"> <ul class=\"nav navbar-nav navbar-right\"> <li class=\"active\"> <a href=\"login\">Login</a> </li> <li> <a href=\"register\">Register</a> </li> </ul> </div> </div> </div> <div class=\"cover-image\" style=\"background-image : url('images/photo-1420708392410-3c593b80d416.jpg')\"> </div> <div class=\"container\"> <div class=\"row\"> <div class=\"col-md-12 text-center\"> <h1 class=\"text-danger\">MatChat</h1> <p class=\"text-danger\">Make you Comfort !</p> <br><br> <a href=\"home\" class=\"btn btn-lg btn-success \">Join Now !</a> </div> </div> </div> </div> <footer class=\"section section-primary\"> <div class=\"container\"> <div class=\"row\"> <div class=\"col-sm-6\"> <h1>Simple Public Chat</h1> <p>Let chat together !<br>Create By Mata</p> </div> <div class=\"col-sm-6\"> <p class=\"text-info text-right\"> <br><br></p> </div> </div> </div> </footer> </body> </html>");
        }else{
            
            out.println("<html> <head> <meta charset=\"utf-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <script src=\"js/jquery.min.js\" type=\"text/javascript\"></script> <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script> <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\"/> <link href=\"css/bootstrapCustom.css\" rel=\"stylesheet\" type=\"text/css\"/> </head> <body> <div class=\"cover\"> <div class=\"navbar navbar-default\"> <div class=\"container\"> <div class=\"navbar-header\"> <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar-ex-collapse\"> <span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span><span class=\"icon-bar\"></span> </button> <a class=\"navbar-brand\" href=\"index\"><span><b>MatChat</b></span></a> </div> <div class=\"collapse navbar-collapse\" id=\"navbar-ex-collapse\"> <ul class=\"nav navbar-nav navbar-right\"> <li class=\"active\"> <a href=\"home\">Home</a> </li> <li> <a href=\"logout\">Logout</a> </li> </ul> </div> </div> </div> <div class=\"cover-image\" style=\"background-image : url('images/photo-1420708392410-3c593b80d416.jpg')\"> </div> <div class=\"container\"> <div class=\"row\"> <div class=\"col-md-12 text-center\"> <h1 class=\"text-danger\">MatChat</h1> <p class=\"text-danger\">Make you Comfort !</p> <br><br> <a href=\"home\" class=\"btn btn-lg btn-success \">Join Now !</a> </div> </div> </div> </div> <footer class=\"section section-primary\"> <div class=\"container\"> <div class=\"row\"> <div class=\"col-sm-6\"> <h1>MatChat</h1>  <p>Let chat together !<br> &lt; Created By Mata /&gt;</p> </div> <div class=\"col-sm-6\"> <p class=\"text-info text-right\"> <br><br></p> </div> </div> </div> </footer> </body> </html>");
        }
    }

    
}

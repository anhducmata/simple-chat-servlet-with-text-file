/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.io.PrintWriter;
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
public class login extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession(false);
        String error = req.getParameter("error");
        System.out.println(error);
        if (session.getAttribute("username") != null) {
            resp.sendRedirect("home");
        }else {
            PrintWriter out=resp.getWriter(); 
            String error_mess ="";
            if (Objects.equals(error, "true")) {
                error_mess = "<div class=\"alert alert-danger\">\n" +
"  <strong>Error !</strong> Username or password incorect.\n" +
"</div>";
            }
            out.println("<html> <head> <meta charset=\"utf-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <script src=\"js/jquery.min.js\" type=\"text/javascript\"></script> <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script> <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\"/> <link href=\"css/bootstrapCustom.css\" rel=\"stylesheet\" type=\"text/css\"/> <style> body{ background: linear-gradient(150deg,#7c798c 15%,#05d5ff 70%,rgba(252, 252, 252, 0.76) 94%); } .panel-heading { padding: 5px 15px; } .panel-footer { padding: 1px 15px; color: #A0A0A0; } .profile-img { width: 96px; height: 96px; margin: 0 auto 10px; display: block; -moz-border-radius: 50%; -webkit-border-radius: 50%; border-radius: 50%; } </style> </head> <body> <div class=\"navbar navbar-default\"> <div class=\"container\"> <div class=\"navbar-header\"> <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar-ex-collapse\"> <span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span><span class=\"icon-bar\"></span> </button> <a class=\"navbar-brand\" href=\"index\"><span><b>MatChat</b></span></a> </div> <div class=\"collapse navbar-collapse\" id=\"navbar-ex-collapse\"> <ul class=\"nav navbar-nav navbar-right\"> <li class=\"active\"> <a href=\"login\">Login</a> </li> <li> <a href=\"register\">Register</a> </li> </ul> </div> </div> </div> <div class=\"container\" style=\"margin-top:40px\"> <div class=\"row\"> <div class=\"col-sm-6 col-md-4 col-md-offset-4\"> <div class=\"panel panel-default\"> <div class=\"panel-heading\"> <strong> Sign in to Join MatChat</strong> </div> <div class=\"panel-body\"> <fieldset> <div class=\"row\"> <div class=\"center-block\"> <img class=\"profile-img\" src=\"images/image1.png\" alt=\"\"> </div> </div> <form role=\"form\" action=\"loginController\" method=\"post\"> <div class=\"row\"> <div class=\"col-sm-12 col-md-10 col-md-offset-1 \"> <div class=\"form-group\"> <div class=\"input-group\"> <span class=\"input-group-addon\"> <i class=\"glyphicon glyphicon-user\"></i> </span> <input class=\"form-control\" placeholder=\"Username\" name=\"username\" type=\"text\" autofocus> </div> </div> <div class=\"form-group\"> <div class=\"input-group\"> <span class=\"input-group-addon\"> <i class=\"glyphicon glyphicon-lock\"></i> </span> <input class=\"form-control\" placeholder=\"Password\" name=\"password\" type=\"password\" value=\"\"> </div> </div> <div class=\"form-group\"> <input type=\"submit\" class=\"btn btn-lg btn-primary btn-block\" value=\"Sign in\"> </div> </div> </div> "+error_mess +"</form> </fieldset> </div> <div class=\"panel-footer \"> Don't have an account! <a href=\"register\" onClick=\"\"> Sign Up Here </a> </div> </div> </div> </div> </div> <footer style=\"position: absolute; bottom: 0px;     right: 0px;     width: 100%;\" class=\"section section-primary\"> <div class=\"container\"> <div class=\"row\"> <div class=\"col-sm-6\"> <h1>MatChat</h1>  <p>Let chat together !<br> &lt; Created By Mata /&gt;</p> </div> <div class=\"col-sm-6\"> <p class=\"text-info text-right\"> <br><br></p> </div> </div> </div> </footer> </body>");
        }
    }

   
}

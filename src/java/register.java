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
public class register extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter out = resp.getWriter();
        HttpSession session=req.getSession(false);  
        System.out.println(session);
        if (session.getAttribute("username") !=null) {
           resp.sendRedirect("home");
        }else{
        out.println("<html> <head> <meta charset=\"utf-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <script src=\"js/jquery.min.js\" type=\"text/javascript\"></script> <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script> <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\"/> <link href=\"css/bootstrapCustom.css\" rel=\"stylesheet\" type=\"text/css\"/> <style> body { background: linear-gradient(150deg,#7c798c 15%,#05d5ff 70%,rgba(252, 252, 252, 0.76) 94%); height: 100%; margin: 0; background-repeat: no-repeat; background-attachment: fixed; } .panel-heading { padding: 5px 15px; } .panel-footer { padding: 1px 15px; color: #A0A0A0; } .profile-img { width: 96px; height: 96px; margin: 0 auto 10px; display: block; -moz-border-radius: 50%; -webkit-border-radius: 50%; border-radius: 50%; } .lbl { position: relative; display: block; height: 20px; width: 44px; background: #898989; border-radius: 100px; cursor: pointer; transition: all 0.3s ease; }\n" +
"\n" +
".lbl:after { position: absolute; left: -2px; top: -3px; display: block; width: 26px; height: 26px; border-radius: 100px; background: #fff; box-shadow: 0px 3px 3px rgba(0,0,0,0.05); content: ''; transition: all 0.3s ease; }\n" +
"\n" +
".lbl:active:after { transform: scale(1.15, 0.85); }\n" +
"\n" +
".cbx:checked ~ label { background: #6fbeb5; }\n" +
"\n" +
".cbx:checked ~ label:after { left: 20px; background: #179588; }\n" +
"\n" +
".cbx:disabled ~ label { background: #d5d5d5; pointer-events: none; }\n" +
"\n" +
".cbx:disabled ~ label:after { background: #bcbdbc; }\n" +
"\n" +
".hidden { display: none; } .material-switch > input[type=\"checkbox\"] { display: none; }\n" +
"\n" +
".material-switch > label { cursor: pointer; height: 0px; position: relative; width: 40px; }\n" +
"\n" +
".material-switch > label::before { background: rgb(0, 0, 0); box-shadow: inset 0px 0px 10px rgba(0, 0, 0, 0.5); border-radius: 8px; content: ''; height: 16px; margin-top: -8px; position:absolute; opacity: 0.3; transition: all 0.4s ease-in-out; width: 40px; } .material-switch > label::after { background: rgb(255, 255, 255); border-radius: 16px; box-shadow: 0px 0px 5px rgba(0, 0, 0, 0.3); content: ''; height: 24px; left: -4px; margin-top: -8px; position: absolute; top: -4px; transition: all 0.3s ease-in-out; width: 24px; } .material-switch > input[type=\"checkbox\"]:checked + label::before { background: inherit; opacity: 0.5; } .material-switch > input[type=\"checkbox\"]:checked + label::after { background: inherit; left: 20px; } </style> </head> <body> <div class=\"navbar navbar-default\"> <div class=\"container\"> <div class=\"navbar-header\"> <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar-ex-collapse\"> <span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span><span class=\"icon-bar\"></span> </button> <a class=\"navbar-brand\" href=\"index\"><span><b>MatChat</b></span></a> </div> <div class=\"collapse navbar-collapse\" id=\"navbar-ex-collapse\"> <ul class=\"nav navbar-nav navbar-right\"> <li > <a href=\"login\">Login</a> </li> <li class=\"active\" > <a href=\"register\">Register</a> </li> </ul> </div> </div> </div> <div class=\"container\" style=\"margin-top:40px\"> <div class=\"row\"> <div class=\"col-sm-6 col-md-4 col-md-offset-4\"> <div class=\"panel panel-default\"> <div class=\"panel-heading\"> <strong> Sign in to Join MatChat</strong> </div> <div class=\"panel-body\"> <form role=\"form\" action=\"registerController\" method=\"post\"> <fieldset> <div class=\"row\"> <div class=\"center-block\"> <img class=\"profile-img\" name=\"image-swap\" src=\"images/image1.png\" alt=\"\"> </div> </div> <div class=\"row\"> <div class=\"col-sm-12 col-md-10 col-md-offset-1 \"> <div class=\"form-group\"> <div class=\"input-group\"> <span class=\"input-group-addon\"> <i class=\"glyphicon glyphicon-user\"></i> </span> <input class=\"form-control\" name=\"username\" placeholder=\"Username\" type=\"text\" min=\"6\" max=\"20\" autofocus> </div> </div> <div class=\"form-group\"> <div class=\"input-group\"> <span class=\"input-group-addon\"> <i class=\"glyphicon glyphicon-sd-video\"></i> </span> <input class=\"form-control\" name=\"age\" placeholder=\"Age\" type=\"number\" min=\"1\" max=\"100\" autofocus> </div> </div> <div class=\"form-group\"> <div class=\"input-group\"> <span class=\"input-group-addon\"> <i class=\"glyphicon glyphicon-lock\"></i> </span> <input class=\"form-control\" placeholder=\"Password\" name=\"password\" type=\"password\" min=\"8\" max=\"20\" value=\"\"> </div> </div> <div class=\"form-group\"> <div class=\"input-group\" style=\" width: 268px;\"> <div class=\"list-group-item\"> Are You Single ? <div class=\"material-switch pull-right\" style=\"margin-top: 10px; padding-right: 30px;\"> <input id=\"single\" class=\"form-control\" name=\"single\" type=\"checkbox\"/> <label for=\"single\" class=\"label-primary\"></label> </div> </div> </div> </div> <div class=\"form-group\"> <div class=\"input-group\" style=\" width: 268px;\"> <div class=\"list-group-item\"> Male <div class=\"material-switch pull-right\"> <input id=\"sex\" class=\"form-control\" name=\"sex\" type=\"checkbox\"/> <label for=\"sex\" class=\"label-primary\" style=\"margin-right: 50px;\" ></label> Female </div> </div> </div> </div> <div class=\"form-group\"> <div class=\"input-group\" style=\" width: 268px;\"> Avatar<select id=\"avatar\" name=\"avatar\" class=\"form-control\"> <option class=\"image1\" value=\"image1\" selected>Mata</option> <option class=\"image2\" value=\"image2\">anonymous</option> <option class=\"image3\" value=\"image3\">Babe</option> <option class=\"image4\" value=\"image4\">Mr.Doctor</option> <option class=\"image5\" value=\"image5\">Mrs.Doctor</option> <option class=\"image6\" value=\"image6\">the Muslims</option> <option class=\"image7\" value=\"image7\">Hacker</option> <option class=\"image8\" value=\"image8\">successful person</option> <option class=\"image9\" value=\"image9\">Mr.Funny</option> <option class=\"image10\" value=\"image10\">scholar</option> <option class=\"image11\" value=\"image11\">Style</option> <option class=\"image12\" value=\"image12\">Woman</option> <option class=\"image13\" value=\"image13\">Girl</option> </select> <script> $(document).ready(function(){ $(\"#avatar\").change(function(){ $(\"img[name=image-swap]\").attr(\"src\", \"images/\"+ $(this).val() + \".png\");\n" +
"\n" +
" });\n" +
"\n" +
"}); </script> </div> </div> <div class=\"form-group\"> <input type=\"submit\" class=\"btn btn-lg btn-primary btn-block\" value=\"Sign Up\"> </div> </div> </div> </fieldset> </form> </div> <div class=\"panel-footer \"> Exist an account! <a href=\"login\" onClick=\"\"> Sign In Here </a> </div> </div> </div> </div> </div> <footer class=\"section section-primary\"> <div class=\"container\"> <div class=\"row\"> <div class=\"col-sm-6\"> <h1>MatChat</h1>  <p>Let chat together !<br> &lt; Created By Mata /&gt;</p> </div> <div class=\"col-sm-6\"> <p class=\"text-info text-right\"> <br><br></p> </div> </div> </div> </footer> </body>");
    }
    }
    
}

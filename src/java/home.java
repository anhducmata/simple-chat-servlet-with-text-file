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
public class home extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session=req.getSession();
        PrintWriter out=resp.getWriter();
        String username = (String)session.getAttribute("username");
        resp.setContentType( "text/html" );
        if (session.getAttribute("username") != null) {
            out.println("<html> <head> <meta content=\"text/html; charset=\"utf-8\"> <meta name=\"viewport\" content=\"width=device-width, initial-scale=1\"> <script src=\"js/jquery.min.js\" type=\"text/javascript\"></script> <script src=\"js/bootstrap.min.js\" type=\"text/javascript\"></script> <link href=\"css/font-awesome.min.css\" rel=\"stylesheet\" type=\"text/css\"/> <link href=\"css/bootstrapCustom.css\" rel=\"stylesheet\" type=\"text/css\"/> <style> .glyphicon { margin-right:5px; } .thumbnail { margin-bottom: 20px; padding: 0px; -webkit-border-radius: 0px; -moz-border-radius: 0px; border-radius: 0px; }\n" +
"\n" + ".item.list-group-item { float: none; width: 100%; background-color: #fff; margin-bottom: 10px; } .item.list-group-item:nth-of-type(odd):hover,.item.list-group-item:hover { background: #428bca; }\n" +
"\n" + ".item.list-group-item .list-group-image { margin-right: 10px; } .item.list-group-item .thumbnail { margin-bottom: 0px; } .item.list-group-item .caption { padding: 9px 9px 0px 9px; } .item.list-group-item:nth-of-type(odd) { background: #eeeeee; }\n" +
"\n" + ".item.list-group-item:before, .item.list-group-item:after { display: table; content: \" \"; }\n" +
"\n" + ".item.list-group-item img { float: left; } .item.list-group-item:after { clear: both; } .list-group-item-text { margin: 0 0 11px; } .list-group-image { width: 400px; height: 250px; }\n" +
"\n" + " </style> <script> $(document).ready(function() { $('#list').click(function(event){event.preventDefault();$('#products .item').addClass('list-group-item');}); $('#grid').click(function(event){event.preventDefault();$('#products .item').removeClass('list-group-item');$('#products .item').addClass('grid-group-item');}); }); </script> </head> <body> <div class=\"navbar navbar-default\"> <div class=\"container\"> <div class=\"navbar-header\"> <button type=\"button\" class=\"navbar-toggle\" data-toggle=\"collapse\" data-target=\"#navbar-ex-collapse\"> <span class=\"sr-only\">Toggle navigation</span> <span class=\"icon-bar\"></span> <span class=\"icon-bar\"></span><span class=\"icon-bar\"></span> </button> <a class=\"navbar-brand\" href=\"index\"><span><b>MatChat</b></span></a> </div> <div class=\"collapse navbar-collapse\" id=\"navbar-ex-collapse\"> <ul class=\"nav navbar-nav navbar-right\"> <li class=\"active\"> <a href=\"login\"><img style=\"width: 25px; height: 25px; margin-right: 10px;\" src=\"images/"+ getAvatar(username) +".png\" alt=\"User Avatar\">"+ username+"</a> </li> <li> <a href=\"logout\">Logout</a> </li> </ul> </div> </div> </div> <div class=\"container\"> <div class=\"well well-sm\" style=\"margin-top: 50px \"> <strong>All Room </strong> <div class=\"btn-group\"> <a href=\"#\" id=\"list\" class=\"btn btn-default btn-sm\"><span class=\"glyphicon glyphicon-th-list\"> </span>List</a> <a href=\"#\" id=\"grid\" class=\"btn btn-default btn-sm\"><span class=\"glyphicon glyphicon-th\"></span>Grid</a> </div> </div> <div id=\"products\" class=\"row list-group\"> <div class=\"item col-xs-4 col-lg-4\"> <div class=\"thumbnail\"> <img class=\"group list-group-image\" src=\"images/roomimages/adult.jpg\" alt=\"\" style=\"width: 400px; height: 300px;\" /> <div class=\"caption\"> <h4 class=\"group inner list-group-item-heading\"> 18+</h4> <p class=\"group inner list-group-item-text\"> This room is only for people over 18 years old. Consider joining rooms !</p> <div class=\"row\"> <div class=\"col-xs-12 col-md-6\"> <p class=\"lead\"> </p> </div> <div  title=\"You Must Be At Least 18 Years Old to Enter this Room\" class=\"col-xs-12 col-md-6\"> <a ");
            
            if (overAdult((String) session.getAttribute("username"))) {
                out.println("class=\"btn btn-success\" href=\"room?room=adult\" ");
            }else{
                out.println("class=\"btn btn-success\" href=\"room?room=adult\" title=\"You Must Be At Least 18 Years Old to Enter thí Room\" style=\"z-index: 999; cursor:not-allowed!important\" disabled=\"disabled\"");
            }
            out.println(">Enter Now !</a> </div> </div> </div> </div> </div> <div class=\"item col-xs-4 col-lg-4\"> <div class=\"thumbnail\"> <img class=\"group list-group-image\" src=\"images/roomimages/man.jpg\" alt=\"\" style=\"width: 400px; height: 300px;\" /> <div class=\"caption\"> <h4 class=\"group inner list-group-item-heading\"> Man</h4> <p class=\"group inner list-group-item-text\"> Men's where the confide the most secret! Just Men bring happiness to each other ! <img style=\" margin-left: 90px;     margin-top: 10px; width:50px; height: 50px; position: absolute\" src=\"images/dau.gif\" /></p> <div class=\"row\"> <div class=\"col-xs-12 col-md-6\"> <p class=\"lead\"> </p> </div> <div class=\"col-xs-12 col-md-6\"> <a class=\"btn btn-success\" href=\"room?room=man\">Enter Now !</a> </div> </div> </div> </div> </div> <div class=\"item col-xs-4 col-lg-4\"> <div class=\"thumbnail\"> <img class=\"group list-group-image\" src=\"images/roomimages/teen.jpg\" alt=\"\" style=\"width: 400px; height: 300px;\" /> <div class=\"caption\"> <h4 class=\"group inner list-group-item-heading\"> TEEN</h4> <p class=\"group inner list-group-item-text\"> For the teen, sharing the difficulties in learning, emotional adolescence !</p> <div class=\"row\"> <div class=\"col-xs-12 col-md-6\"> <p class=\"lead\"> </p> </div> <div class=\"col-xs-12 col-md-6\"> <a class=\"btn btn-success\" href=\"room?room=teen\">Enter Now !</a> </div> </div> </div> </div> </div> <div class=\"item col-xs-4 col-lg-4\"> <div class=\"thumbnail\"> <img class=\"group list-group-image\" src=\"images/roomimages/women.jpg\" alt=\"\" style=\"width: 400px; height: 300px;\" /> <div class=\"caption\"> <h4 class=\"group inner list-group-item-heading\"> Women</h4> <p class=\"group inner list-group-item-text\"> Confided of women, family, couple confided extramarital affairs, the difficulties of love and life !</p> <div class=\"row\"> <div class=\"col-xs-12 col-md-6\"> <p class=\"lead\"> </p> </div> <div class=\"col-xs-12 col-md-6\"> <a class=\"btn btn-success\" href=\"room?room=women\">Enter Now !</a> </div> </div> </div> </div> </div> <div class=\"item col-xs-4 col-lg-4\"> <div class=\"thumbnail\"> <img class=\"group list-group-image\" src=\"images/roomimages/datting.jpg\" alt=\"\" style=\"width: 400px; height: 300px;\" /> <div class=\"caption\"> <h4 class=\"group inner list-group-item-heading\"> DATTING</h4> <p class=\"group inner list-group-item-text\"> connected love, looking for love, confide about love, and more !</p> <div class=\"row\"> <div class=\"col-xs-12 col-md-6\"> <p class=\"lead\"> </p> </div> <div class=\"col-xs-12 col-md-6\"> <a ");
            if (checkSingle((String) session.getAttribute("status"))) {
                out.println("class=\"btn btn-success\" href=\"room?room=datting\" ");
            }else{
                out.println("class=\"btn btn-success\" href=\"room?room=datting\" title=\"You are married !\" style=\"z-index: 999; cursor:not-allowed!important\" disabled=\"disabled\"");
            }
            out.println(">Enter Now!</a> </div> </div> </div> </div> </div> <div class=\"item col-xs-4 col-lg-4\"> <div class=\"thumbnail\"> <img class=\"group list-group-image\" src=\"images/roomimages/anonymous.jpg\" alt=\"\" style=\"width: 400px; height: 300px;\" /> <div class=\"caption\"> <h4 class=\"group inner list-group-item-heading\"> Secrect Room</h4> <p class=\"group inner list-group-item-text\"> You can chat comfortably without leaving any privacy information !</p> <div class=\"row\"> <div class=\"col-xs-12 col-md-6\"> <p class=\"lead\"> </p> </div> <div class=\"col-xs-12 col-md-6\"> <a class=\"btn btn-success\" href=\"room?room=anonymous\">Enter Now !</a> </div> </div> </div> </div> </div> </div> </div> <footer class=\"section section-primary\"> <div class=\"container\"> <div class=\"row\"> <div class=\"col-sm-6\"> <h1>MatChat</h1>  <p>Let chat together !<br> &lt; Created By Mata /&gt;</p> </div> <div class=\"col-sm-6\"> <p class=\"text-info text-right\"> <br><br></p> </div> </div> </div> </footer> </body>");
        }else{
            resp.sendRedirect("login");
        }
    }
    private boolean checkSingle(String status){
        return Objects.equals(status, "single");
    }
    private boolean overAdult(String session) throws IOException{
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
}

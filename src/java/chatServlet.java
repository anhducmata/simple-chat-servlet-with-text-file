/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.FileNotFoundException;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;
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
public class chatServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
      HttpSession session=req.getSession(false);  
      String username=(String)session.getAttribute("username");  
      String message = req.getParameter("message");
      String room = req.getParameter("room");
      Date date = new Date();
      SimpleDateFormat sdf = new SimpleDateFormat("h:mm:ss - a - dd/MM");
      String formattedDate = sdf.format(date);
        if (Objects.equals(room, "anonymous")) {
            username = "Anonymous";
        }
      String mess = username + "|" + message + "|" + formattedDate;
        try {
            insertMess(mess, room);
            resp.sendRedirect("room?room="+ room);
        } catch (Exception e) {
            e.getMessage();
        }
    }
    private void insertMess(String mess, String room) throws FileNotFoundException, IOException{
        String file_name="G:\\Project\\ChatRoom\\ChatRoom\\room\\"+ room +".txt";
        WriteFile data=new WriteFile(file_name,true);
        data.writeToFile(mess);
    }   
}

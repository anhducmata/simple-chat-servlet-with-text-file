/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 *
 * @author Mata
 */
public class logout extends HttpServlet {
      protected void doGet(HttpServletRequest request, HttpServletResponse response)  
                                throws ServletException, IOException {  
            response.setContentType("text/html"); 
            
            HttpSession session = request.getSession(false);
            session.invalidate();
            response.sendRedirect("index");
    }  
}

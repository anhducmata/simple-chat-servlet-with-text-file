/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
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
public class loginController extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       String username = req.getParameter("username");
       String password = req.getParameter("password");
        
            if(checkLogin(username, password, req)){
                HttpSession session=req.getSession();  
                session.setAttribute("username",username);  
                resp.sendRedirect("home");
                
            }else{
                resp.sendRedirect("login?error=true");
            }
    }

    private boolean checkLogin(String username,String password, HttpServletRequest req) throws IOException{
        password = md5(password);
        String file_name="G:\\Project\\ChatRoom\\ChatRoom\\user.txt";      
        Readfile file=new Readfile(file_name);
        String[] aryLines;
        aryLines = file.OpenFile();
        int i = 0;
        while (i < aryLines.length ) {
            String[] array = aryLines[i].split("\\|", -1);
            if (Objects.equals(array[1], username) && Objects.equals(array[2], password)) {
                HttpSession session=req.getSession();  
                session.setAttribute("status", array[3]);  
                return true;
            }
            i++;
        }
        return false;
    }
    private String md5(String input) {
        String md5 = null;
	if(null == input) return null;	
	try {
            MessageDigest digest = MessageDigest.getInstance("MD5");
            digest.update(input.getBytes(), 0, input.length());
            md5 = new BigInteger(1, digest.digest()).toString(16);
	} catch (NoSuchAlgorithmException e) {	
        }
        return md5;
    }
}

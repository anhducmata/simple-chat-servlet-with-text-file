    /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.*;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Mata
 */
public class registerController extends HttpServlet {
      
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String username=req.getParameter("username");  
        String password= req.getParameter("password");
        password = md5(password);  
        String single=req.getParameter("single");
        String age = req.getParameter("age");
        String avatar = req.getParameter("avatar");
        if (single != null) {
            single = "married";
        }else{
            single = "single";
        }
        String sex=req.getParameter("sex"); 
        if (sex != null) {
            sex = "male";
        }else{
            sex = "female";
        }
        int id = lastId()+1;
        String user = id + "|" + username + "|" + password + "|" + single + "|" + sex  + "|" + age + "|" + avatar;
        if(checkUser(username)){
            insertUser(user);
            resp.sendRedirect("login");

        }else{
            resp.sendRedirect("register");
        }
        
    }

    private void insertUser(String user) throws FileNotFoundException, IOException{
        String file_name="G:\\Project\\ChatRoom\\ChatRoom\\user.txt";
        WriteFile data=new WriteFile(file_name,true);
        data.writeToFile(user);
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
    private int lastId() throws IOException{
        int id = 0;
        String file_name="G:\\Project\\ChatRoom\\ChatRoom\\user.txt";      
        Readfile file=new Readfile(file_name);
        String[] aryLines=file.OpenFile();
        int i = aryLines.length - 1;
        String[] array = aryLines[i].split("\\|", -1);
        id = Integer.parseInt(array[0]);
        System.out.println(id);
        return id;
    }
    private boolean checkUser(String username) throws IOException{
        String file_name="G:\\Project\\ChatRoom\\ChatRoom\\user.txt";      
        Readfile file=new Readfile(file_name);
        String[] aryLines=file.OpenFile();
        int i = 0;
        while (i < aryLines.length ) {
            String[] array = aryLines[i].split("\\|", -1);
            if (Objects.equals(array[1],username)) { // must using Objects.equals()
                return false;
            }
            i++;
            
        }
        return true;
    }
}

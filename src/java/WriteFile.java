/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.io.*;

/**
 *
 * @author ahmadhalah
 */
public class WriteFile {
        private String path;
        private boolean  append=false;
        
        public WriteFile(String file_path,boolean append_to){
            path=file_path;
            append=append_to;
        }
    
        public void writeToFile(String Textlines) throws IOException{
            
            FileWriter write=new FileWriter(path,append);
            PrintWriter print_line=new PrintWriter(write);
            print_line.printf("%s"+"%n",Textlines);
            print_line.close();
        }   
}

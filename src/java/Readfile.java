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
 class Readfile {
    
    private final String path;
    
    public Readfile(String file_path){
        path=file_path;
    }
    
     public String[] OpenFile() throws IOException{
         
        int lines= count(path);
        String[] textData=new String[lines];
        
        try{
        FileReader fr= new FileReader(path);
        BufferedReader textReader= new BufferedReader(fr);
        
        
        for(int i=0;i<lines;i++)
            textData[i]=textReader.readLine();
            
          textReader.close();
        }
        catch(IOException e){
            System.out.print(e.getMessage());
        }
        

                       return textData;
 }
     public int count(String filename) throws IOException {
    InputStream is = new BufferedInputStream(new FileInputStream(filename));
    try {
        byte[] c = new byte[1024];
        int count = 0;
        int readChars = 0;
        boolean endsWithoutNewLine = false;
        while ((readChars = is.read(c)) != -1) {
            for (int i = 0; i < readChars; ++i) {
                if (c[i] == '\n')
                    ++count;
            }
            endsWithoutNewLine = (c[readChars - 1] != '\n');
        }
        if(endsWithoutNewLine) {
            ++count;
        } 
        return count;
    } finally {
        is.close();
    }
}
 }


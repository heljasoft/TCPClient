
package tcpclient;

import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


public class TCPClient {

   
    public static void main(String[] args) {
        
        try (Socket cn = new Socket("www.google.com", 80);
                BufferedReader bis = new BufferedReader(new InputStreamReader(cn.getInputStream()));
                BufferedOutputStream bos =  new BufferedOutputStream(cn.getOutputStream());)
        {
            bos.write("GET /search?q=java HTTP/1.1\r\n\r\n".getBytes());
            bos.flush();
            
            //logika za citanje od servera
            String line = bis.readLine();
            while (line != null) {                
                System.out.println(line);
                line = bis.readLine();
            }
        } catch (IOException ex) {
            System.out.println("Error in connection: "+ ex.getMessage());
        }
        
    }
    
}

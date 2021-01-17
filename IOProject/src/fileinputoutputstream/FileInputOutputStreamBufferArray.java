package fileinputoutputstream;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileInputOutputStreamBufferArray {
    public static void main(String[] args) {
        long startTime = 0;
        int countBytes=0;
        try (FileInputStream fis = new FileInputStream(new File("tmp/BscITProgram.pdf"));
                FileOutputStream fos = new FileOutputStream("tmp/BscITProgram_copy.pdf")) {

            startTime = System.nanoTime();
            System.out.println("Start Time: " + startTime);
            byte data []= new byte[8192];
            System.out.println("available bytes: " + fis.available());
            
            while (fis.available()!= 0) {
                fis.read(data);
                fos.write(data);
            }
           
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        long estimatedTime = System.nanoTime() - startTime;

        System.out.println("Elapsed Time is " + (estimatedTime / 1000000.0) + " msec");
        
        /*File size: 1,249,280 bytes
        Start Time: 43622726775000
        available bytes: 1246030
        Elapsed Time is 3.6532 msec*/
    }
}

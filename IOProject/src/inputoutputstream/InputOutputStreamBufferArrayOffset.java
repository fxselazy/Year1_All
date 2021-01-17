package inputoutputstream;

import java.io.IOException;

public class InputOutputStreamBufferArrayOffset {
    public static void main(String[] args) {
         byte data[] = new byte[5];
        try {
            int countBytes=System.in.read(data);
            System.out.println("number of bytes: "+countBytes);       
            System.out.write(data, 1, 2);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
    
}

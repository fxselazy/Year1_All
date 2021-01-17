package inputoutputstream;
import java.io.IOException;
public class InputOutputStreamBufferArray {
    public static void main(String[] args) {
        byte data[] = new byte[5];
        try {
            int countBytes=System.in.read(data);
            System.out.println("number of bytes: "+countBytes);
            System.out.write(data);

        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

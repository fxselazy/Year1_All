package inputoutputstream;
import java.io.IOException;

public class InputOutputStreamSingleByte {
    public static void main(String[] args) {
        int data;
        try {
            while((data=System.in.read())!=-1){
                System.out.write(data);
            }
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}
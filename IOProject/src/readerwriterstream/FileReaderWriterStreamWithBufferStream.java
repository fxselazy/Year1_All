package readerwriterstream;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class FileReaderWriterStreamWithBufferStream {
     public static void main(String[] args) {
        String output=null;
        try (FileReader fr = new FileReader(new File("tmp/quote.txt"));
            BufferedReader br=new BufferedReader(fr);
            PrintWriter fw = new PrintWriter(System.out);
            BufferedWriter bw=new BufferedWriter(fw)) {
           
            String data;
            while ((data = br.readLine())!=null) {
                bw.write(data);
                bw.write('\n');
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
     }
}

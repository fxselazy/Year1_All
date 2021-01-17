package readerwriterstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterStreamBufferArray {
     public static void main(String[] args) {
       try (FileReader fr = new FileReader(new File("tmp/words.txt"));
                FileWriter fw = new FileWriter("tmp/words_copy.txt")) {
            char data[]=new char[10];
            int countChars;
            while ((countChars=fr.read(data))!= -1) {
                System.out.println("number of chars: "+countChars);
                if(countChars<data.length)
                    fw.write(data,0, countChars);
                else
                    fw.write(data);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

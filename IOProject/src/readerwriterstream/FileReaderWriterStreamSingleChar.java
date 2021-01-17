package readerwriterstream;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileReaderWriterStreamSingleChar {

    public static void main(String[] args) {
        try (FileReader fr = new FileReader(new File("tmp/words.txt"));
                FileWriter fw = new FileWriter("tmp/words_copy.txt")) {
            int data;
            while ((data = fr.read()) != -1) {
                System.out.print((char) data);
                fw.write(data);
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }
}

package objectinputoutputstream;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
;
import model.Member;
import model.MemberInClass;

public class ObjectInputOutputStream {
    public static void writeMembersInClass(MemberInClass mb) {
        try (FileOutputStream fos = new FileOutputStream("tmp/membersinclass"+"-"+mb.getClassDate()+"-"+mb.getCourse()+".dat");
               ObjectOutputStream oos = new ObjectOutputStream(fos)) {
            oos.writeObject(mb);

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static MemberInClass readMembersInClass(String fileName) {
        MemberInClass mic=null;
        try (FileInputStream fis = new FileInputStream(fileName);
                ObjectInputStream ois = new ObjectInputStream(fis)) {
            
            while(fis.available()!=0){
               mic=(MemberInClass) ois.readObject();
            }
           
        }catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }catch (IOException ex) {
            ex.printStackTrace();
        } catch (ClassNotFoundException ex) {
           ex.printStackTrace();
        }
        return mic;
    }

    public static void main(String[] args) {
        Member m1=new Member(1001, "Paul", true);
        Member m2=new Member(1002, "Jane", false);
        Member m3=new Member(1003, "April", true);
        
        Member recordMembers[]={m1, m2, m3};
        MemberInClass mic=new MemberInClass("INT103", LocalDate.now(), recordMembers);
        writeMembersInClass(mic);
        MemberInClass attendMember=readMembersInClass("tmp/membersinclass-2020-03-31-INT103.dat");
        
        System.out.println(attendMember);
    }
}

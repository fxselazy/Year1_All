package datainputoutputstream;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.LocalDate;
import model.Member;
import model.MemberInClass;

public class DataInputOutputStreamWithBufferStream {

    public static void writeMembersInClass(MemberInClass mb) {
        try (FileOutputStream fos = new FileOutputStream("tmp/members"+"-"+mb.getClassDate()+"-"+mb.getCourse()+".dat");
                BufferedOutputStream bos=new BufferedOutputStream(fos);
                DataOutputStream dos = new DataOutputStream(bos)) {

            int numOfMembers = mb.getMembers().length;
            Member[] members=mb.getMembers();
            
            dos.writeInt(numOfMembers);
            for (int i = 0; i < numOfMembers; i++) {
                dos.writeLong(members[i].getMemberId());
                dos.writeUTF(members[i].getMemberName());
                dos.writeBoolean(members[i].isAttend());
            }

        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }

    public static Member[] readMembersInClass(String fileName) {
        Member[] readMembers=null;
        try (FileInputStream fis = new FileInputStream(fileName);
                BufferedInputStream bis=new BufferedInputStream(fis);
                DataInputStream dis = new DataInputStream(bis)) {
            
            int numOfMembers = dis.readInt();
            readMembers=new Member[numOfMembers];
            for (int i = 0; i < numOfMembers; i++) {
                readMembers[i]=new Member(dis.readLong(), dis.readUTF(), dis.readBoolean());
            }
           
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return readMembers;
    }

    public static void main(String[] args) {
        Member m1=new Member(1001, "Paul", true);
        Member m2=new Member(1002, "Jane", false);
        Member m3=new Member(1003, "April", true);
        
        Member recordMembers[]={m1, m2, m3};
        MemberInClass mic=new MemberInClass("INT103", LocalDate.now(), recordMembers);
        writeMembersInClass(mic);
        Member readMembersFromFile[]=readMembersInClass("tmp/members-2020-03-31-INT103.dat");
        
        for (int i = 0; i < readMembersFromFile.length; i++) {
            System.out.println(readMembersFromFile[i]);
            
        }
    }
}

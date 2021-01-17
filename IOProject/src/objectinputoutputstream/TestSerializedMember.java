package objectinputoutputstream;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.time.LocalDate;
import model.Member;

public class TestSerializedMember {
    public static void readMembers(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            SerializedMember sm = (SerializedMember) ois.readObject();
            Member members[] = sm.getMembers();
            for (int i = 0; i < members.length; i++) {
                System.out.println(members[i]);

            }

        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public static void writeMembers(String fileName, Member[] members) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            SerializedMember sm = new SerializedMember(members);
            oos.writeObject(sm);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        Member m1 = new Member(1001, "Paul", true);
        Member m2 = new Member(1002, "Jane", false);
        Member m3 = new Member(1003, "April", true);

        Member nonSerializedMembers[] = {m1, m2, m3};

        writeMembers("tmp/members" + "-" + LocalDate.now() + ".dat", nonSerializedMembers);
        readMembers("tmp/members" + "-" + LocalDate.now() + ".dat");

    }
}

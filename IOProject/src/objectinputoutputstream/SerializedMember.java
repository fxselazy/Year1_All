package objectinputoutputstream;

import java.io.DataOutputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import model.Member;

public class SerializedMember implements Serializable {
    private Member[] members;

    public SerializedMember(Member[] members) {
        this.members = members;
    }

    public Member[] getMembers() {
        return members;
    }

    private void readObject(ObjectInputStream ois)
            throws IOException, ClassNotFoundException {
        members = new Member[ois.readInt()];
        for (int i = 0; i < members.length; i++) {
            members[i] = new Member(ois.readLong(), ois.readUTF(), ois.readBoolean());
        }
    }

    private void writeObject(ObjectOutputStream oos)
            throws IOException {
        int numOfMembers = members.length;
        oos.writeInt(numOfMembers);
        for (int i = 0; i < numOfMembers; i++) {
            oos.writeLong(members[i].getMemberId());
            oos.writeUTF(members[i].getMemberName());
            oos.writeBoolean(members[i].isAttend());
        }

    }

}

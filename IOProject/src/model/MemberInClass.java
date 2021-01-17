package model;

//import java.io.Serializable;
import java.time.LocalDate;

public class MemberInClass {//implements Serializable{

    private String course;
    private LocalDate classDate;
    private Member members[];

    public MemberInClass(String course, LocalDate classDate, Member[] members) {
        this.course = course;
        this.classDate = classDate;
        this.members = members;
    }

    public String getCourse() {
        return course;
    }

    public Member[] getMembers() {
        return members;
    }

    public LocalDate getClassDate() {
        return classDate;
    }

    @Override
    public String toString() {
        StringBuilder str = new StringBuilder();
        str.append("MemberInClass{" + "course=" + course + ", classDate=" + classDate + '}'+"\n");
        for (int i = 0; i < members.length; i++) {
            str.append(members[i]+"\n");

        }
        return str.toString();
    }

}

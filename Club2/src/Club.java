
public class Club {

    private String fullName, abb;
    private int amount, studentAmount = 0;
    private Student[] members;

    public Club(String fullName, String abb, int amount) {
        this.fullName = fullName;
        this.abb = abb;
        members = new Student[amount];
    }

    public int isLive(long id) {
        for (int i = 0; i < studentAmount; i++) {
            if (members[i].getStudentId().equals(id)) {
                return i;
            }
        }
        return -1;
    }

    public void addMember(Student student) {
        if (student != null) {
            members[studentAmount++] = student;
        }
    }

    public void removeMember(long id) {
        for (int i = isLive(id); i < studentAmount; i++) {
            if (i == studentAmount - 1) {
                members[i] = null;
            } else {
                members[i] = members[i + 1];
            }
        }
        studentAmount--;
    }
    
    public void editMember(Student student){
        members[isLive(student.getStudentId())] = student;
    }

    public String getFullName() {
        return fullName;
    }

    public int getAmount() {
        return amount;
    }

    public boolean isFull() {
        return studentAmount >= members.length;
    }

    public int getStudentAmount() {
        return studentAmount;
    }

    public Student[] getMembers() {
        return members;
    }

    public String getAbb() {
        return abb;
    }
    
    public String toString(){
        StringBuilder C = new StringBuilder();
        C.append("Club Name: ");
        C.append(fullName);
        C.append("\nShortname: ");
        C.append(abb);
        C.append("\nAmount of Members: ");
        C.append(studentAmount + "/" + members.length);
        C.append("\nStatus: " + (isFull() ? "Close" : "Open"));
        return C.toString();
    }
}

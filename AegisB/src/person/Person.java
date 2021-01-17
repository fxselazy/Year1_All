package person;

public class Person {

    private int Id;
    private String FirstName;
    private String LastName;

    public Person(int Id, String FirstName, String LastName) {
        this.Id = Id;
        this.FirstName = FirstName;
        this.LastName = LastName;
    }

    public long getId() {
        return Id;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public void setFirstName(String FirstName) {
        this.FirstName = FirstName;
    }

    public void setLastName(String LastName) {
        this.LastName = LastName;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠\n");
        sb.append("ID: ").append(Id).append("\n");
        sb.append("Firstname: ").append(FirstName).append("\n");
        sb.append("Lastname: ").append(LastName).append("\n");
        sb.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");

        return sb.toString();
    }

}

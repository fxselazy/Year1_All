package account;

import java.util.Objects;
import person.Person;

public class Account {

    private int Id;
    private String password;
    private Person person;
    private Position position;

    public Account(int Id, String password, Person person, Position position) {
        this.Id = Id;
        this.password = password;
        this.person = person;
        this.position = position;
    }

    public Account(int id, String password) {
        try {
            this.Id = id;
            this.password = password;
        } catch (NullPointerException e) {
            System.out.println("Your Id and/or password is incorrect, please try again");
        }
    }

    public int getId() {
        return Id;
    }

    public String getPassword() {
        return password;
    }

    public Person getPerson() {
        return person;
    }

    public Position getPosition() {
        return position;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Account other = (Account) obj;
        if (this.Id != other.Id) {
            return false;
        }
        if (!Objects.equals(this.password, other.password)) {
            return false;
        }
        if (!Objects.equals(this.person, other.person)) {
            return false;
        }
        if (this.position != other.position) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
       StringBuilder st = new StringBuilder();
    
        try {
        
        st.append("               <<My profile>>");
        st.append("\n ");    
        
        st.append(this.getPerson().toString());
        st.append("\n");
        st.append("---------------------------------------------------------------------\n");
    }catch(NullPointerException ex){

}
return st.toString();
}
}

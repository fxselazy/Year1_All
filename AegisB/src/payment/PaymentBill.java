package payment;

import account.Position;
import account.StudentAccount;
import courses.Courses;
import person.Person;
import service.RegisterCourses;

public class PaymentBill {

    private double totalPay;
    private RegisterCourses registerCourses;

    public PaymentBill(double totalPay, RegisterCourses registerCourses) {
        
        this.totalPay = totalPay;
        this.registerCourses = registerCourses;
    }

    public double getTotalPay() {
        return totalPay;
    }

    public RegisterCourses getRegisterCourses() {
        return registerCourses;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠\n");
        st.append("/n");
        st.append("           Payment Bill             /n");
        st.append("/n");
        st.append("Id: ").append(super.toString());
        st.append("   Total pay: ").append(this.totalPay).append("/n");
        st.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");
        return st.toString();
    }

}

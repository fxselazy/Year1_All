package service;

import account.Position;
import account.StudentAccount;
import courses.Courses;
import person.Person;

public class RegisterCourses {

    private StudentAccount studentAccount;
    private Courses courses;
    private int count;
    private int TotalPay;

    public RegisterCourses( Courses courses) {
        this.courses = courses; 
        count++;
        this.TotalPay = this.courses.getCalCost();

    }

    public void setCourses(Courses courses) {
        this.courses = courses;
    }

 

    public StudentAccount getStudentAccount() {
        return studentAccount;
    }

    public Courses getCourses() {
        return courses;
    }

    public int getCount() {
        return count;
    }

//    public int calculateForPay() {
//        int i;
//        for (i = 0; i < courses.length; i++) {
//            TotalPay += courses[i].getCalCost();
//        }
//
//        return TotalPay;
//    }

    public double getTotalPay() {
        return TotalPay;
    }

  @Override
    public String toString() {

        StringBuilder sb = new StringBuilder();



        sb.append("Courses name: ").append(courses.getSubject()).append("\n");
        sb.append("Course code: ").append(courses.getCourseCode()).append("\n");
        sb.append("Course cost: ").append(courses.getCalCost()).append("\n");
//        sb.append("Count: ").append(count).append("\n");

        sb.append("----------------------------------------------");

        return sb.toString();
    }

}

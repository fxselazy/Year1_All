package courses;

public class Courses {

    private String courseCode;
    private String subject;
    private int credits;
    private final int cost = 1200;
    private int calCost;

    public Courses(String courseCode, String subject, int credits) {
        this.subject = subject != null ? subject : null;
        try {
            this.courseCode = courseCode;
        } catch (NullPointerException e) {
            this.courseCode = "UnknowSubject";
        } finally {
            this.courseCode = courseCode;
        }

        try {
            this.subject = subject;

        } catch (NullPointerException e) {
            this.subject = "UnknowSubject";
        } finally {
            this.subject = subject;
        }

        this.credits = credits > 0 && credits <= 3 ? credits : -1;
        this.calculateCost(credits);


    }

    public Courses(String coursesCode) {
        try {
            this.courseCode = courseCode;
        } catch (NullPointerException e) {
            this.courseCode = "UnknowSubject";
        }
    }

    public void calculateCost(int credits) {
        int x = this.cost * this.credits;
        this.calCost = x;
    }

    public String getCourseCode() {
        return courseCode;
    }

    public String getSubject() {
        return subject;
    }

    public int getCredits() {
        return credits;
    }

    public int getCalCost() {
        return calCost;
    }

    @Override
    public String toString() {
        StringBuilder st = new StringBuilder();
        st.append("\n♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");
        st.append("\n");
        st.append("Couses Code: ").append(this.courseCode);
        st.append("\n");
        st.append("Subject: ").append(this.subject);
        st.append("\n");
        st.append("Credits: ").append(this.credits);
        st.append("\n");
        st.append("Cost: ").append(this.calCost);
        st.append("\n");
        st.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠\n");
        return st.toString();
    }

}

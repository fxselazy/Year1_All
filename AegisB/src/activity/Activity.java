package activity;

import java.time.LocalDate;
import java.util.Objects;

public class Activity {

    private String codeAct;
    private int hour;
    private String nameOfActivity;

    public Activity(String codeAct, String nameOfActivity, int hour) {
        this.hour = hour;

        try {
            this.codeAct = codeAct;
            this.nameOfActivity = nameOfActivity;
        } catch (NullPointerException e) {
            System.out.println("Unknown Activity");
        } finally {
            this.nameOfActivity = nameOfActivity;
        }
    }

    public Activity(String codeAct) {
        try {
            this.codeAct = codeAct;
        } catch (NullPointerException e) {
            System.out.println("Unknown Activity");
        }
    }

    public String getNameOfActivity() {
        return nameOfActivity;
    }

    public int getHour() {
        return hour;
    }

    public String getCodeAct() {
        return codeAct;
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
        final Activity other = (Activity) obj;
        if (!Objects.equals(this.nameOfActivity, other.nameOfActivity)) {
            return false;
        }
        if (!Objects.equals(this.hour, other.hour)) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        sb.append("\n♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");
        sb.append("\n");
        sb.append("Activity Code: ").append(this.codeAct);
        sb.append("\n");
        sb.append("Activity Name: ").append(nameOfActivity);
        sb.append("\n");
        sb.append("Activity Hour: ").append(hour);
        sb.append("\n");
        sb.append("♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠♠");

        return sb.toString();
    }

}

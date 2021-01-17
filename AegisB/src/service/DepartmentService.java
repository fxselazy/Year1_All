package service;

import account.Account;
import account.DepartmentAccount;
import account.StudentAccount;
import activity.Activity;
import courses.Courses;
import payment.PaymentStatus;

public interface DepartmentService {

   

    public boolean addMember( StudentAccount account);

   

    public boolean addActivityHour( Activity activity, int id);

 

    

    public boolean changePaymentStatus( int id, PaymentStatus status);

}

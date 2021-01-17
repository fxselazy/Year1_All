package model;

//import java.io.Serializable;

public class Member {//implements Serializable {
    private long memberId;
    private transient String memberName;
    private boolean attend;
    
    public Member(long memberId, String memberName) {
        this.memberId = memberId;
        this.memberName = memberName;
    }

    public Member(long memberId, String memberName, boolean attend) {
        this.memberId = memberId;
        this.memberName = memberName;
        this.attend = attend;
    }

    public long getMemberId() {
        return memberId;
    }

    public String getMemberName() {
        return memberName;
    }

    public boolean isAttend() {
        return attend;
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
        final Member other = (Member) obj;
        if (this.memberId != other.memberId) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Member{" + "memberId=" + memberId + ", memberName=" + memberName + ", attend=" + attend + '}';
    }
     
    
    

   

    

    
    
    

}

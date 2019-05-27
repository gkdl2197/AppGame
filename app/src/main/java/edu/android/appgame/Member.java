package edu.android.appgame;

import com.google.firebase.database.Exclude;

import java.util.HashMap;
import java.util.Map;

public class Member {

    private String memberId;
    private String memberEmail;
    private String memberPassword;
    private String memberPasswordCheck;
    private String memberName;
    private String memberSex;
    private String memberBirth;

    private int gameScore;


    public Member(String memberId, String memberEmail, String memberPassword, String memberPasswordCheck, String memberName, String memberSex, String memberBirth) {
        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberPasswordCheck = memberPasswordCheck;
        this.memberName = memberName;
        this.memberSex = memberSex;
        this.memberBirth = memberBirth;
    }

    public String getMemberId() {
        return memberId;
    }

    public void setMemberId(String memberId) {
        this.memberId = memberId;
    }

    public String getMemberEmail() {
        return memberEmail;
    }

    public void setMemberEmail(String memberEmail) {
        this.memberEmail = memberEmail;
    }

    public String getMemberPassword() {
        return memberPassword;
    }

    public void setMemberPassword(String memberPassword) {
        this.memberPassword = memberPassword;
    }

    public String getMemberPasswordCheck() {
        return memberPasswordCheck;
    }

    public void setMemberPasswordCheck(String memberPasswordCheck) {
        this.memberPasswordCheck = memberPasswordCheck;
    }

    public String getMemberName() {
        return memberName;
    }

    public void setMemberName(String memberName) {
        this.memberName = memberName;
    }

    public String getMemberSex() {
        return memberSex;
    }

    public void setMemberSex(String memberSex) {
        this.memberSex = memberSex;
    }

    public String getMemberBirth() {
        return memberBirth;
    }

    public void setMemberBirth(String memberBirth) {
        this.memberBirth = memberBirth;
    }

    @Exclude
    public Map<String, Object> toMap(){
        HashMap<String, Object> result = new HashMap<>();

        result.put("id", memberId);
        result.put("email", memberEmail);
        result.put("password", memberPassword);
        result.put("password2", memberPasswordCheck);
        result.put("name", memberName);
        result.put("sex", memberSex);
        result.put("birth", memberBirth);


        return result;
    } // end toMap()


} // end class Member

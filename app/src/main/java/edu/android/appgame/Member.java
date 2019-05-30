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

    private int quiz;
    private int card;
    private int word;
    private int calculate;
    private int qclick;



    public Member(String memberId, String memberEmail, String memberPassword, String memberPasswordCheck, String memberName, String memberSex, String memberBirth) {
        this.memberId = memberId;
        this.memberEmail = memberEmail;
        this.memberPassword = memberPassword;
        this.memberPasswordCheck = memberPasswordCheck;
        this.memberName = memberName;
        this.memberSex = memberSex;
        this.memberBirth = memberBirth;
    }

    public Member(int quiz, int card, int word, int calculate, int qclick){
        this.quiz = quiz;
        this.card = card;
        this.word = word;
        this.calculate = calculate;
        this.qclick = qclick;
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

    public int getQuiz() {
        return quiz;
    }

    public void setQuiz(int quiz) {
        this.quiz = quiz;
    }

    public int getCard() {
        return card;
    }

    public void setCard(int card) {
        this.card = card;
    }

    public int getWord() {
        return word;
    }

    public void setWord(int word) {
        this.word = word;
    }

    public int getCalculate() {
        return calculate;
    }

    public void setCalculate(int calculate) {
        this.calculate = calculate;
    }

    public int getQclick() {
        return qclick;
    }

    public void setQclick(int qclick) {
        this.qclick = qclick;
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
        result.put("quiz", quiz);
        result.put("card", card);
        result.put("word", word);
        result.put("calculate", calculate);
        result.put("qclick", qclick);

        return result;
    } // end toMap()

    @Exclude
    public Map<String, Object> toMapScore(){
        HashMap<String, Object> result = new HashMap<>();

//        result.put("quiz", quiz);
//        result.put("card", card);
//        result.put("word", word);
//        result.put("calculate", calculate);
//        result.put("qclick", qclick);

        return result;
    } // end toMap()

} // end class Member

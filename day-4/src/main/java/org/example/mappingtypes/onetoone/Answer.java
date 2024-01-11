//package org.example.mappingtypes.onetoone;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//
//@Entity
//public class Answer {
//    @Id
//    private  int a_id;
//    private String ans;
//
//    @OneToOne
//    private Questions question;
//
//    public Questions getQuestion() {
//        return question;
//    }
//
//    public void setQuestion(Questions question) {
//        this.question = question;
//    }
//
//    public Answer() {
//
//    }
//    public Answer(int a_id, String ans) {
//        this.a_id = a_id;
//        this.ans = ans;
//    }
//    public int getA_id() {
//        return a_id;
//    }
//
//    public void setA_id(int a_id) {
//        this.a_id = a_id;
//    }
//
//    public String getAns() {
//        return ans;
//    }
//
//    public void setAns(String ans) {
//        this.ans = ans;
//    }
//    @Override
//    public String toString() {
//        return "Answer{" +
//                "a_id=" + a_id +
//                ", ans='" + ans + '\'' +
//                '}';
//    }
//}

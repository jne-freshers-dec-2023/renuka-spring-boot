//package org.example.mappingtypes.onetoone;
//
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.OneToOne;
//
//@Entity
//public class Questions {
//    @Id
//    private int q_id;
//    private String question;
//
//    public Questions() {
//    }
//
//    public void setAnswer(Answer answer) {
//        this.answer = answer;
//    }
//
//    @OneToOne
//    private Answer answer;
//    public int getQ_id() {
//        return q_id;
//    }
//    public void setQ_id(int q_id) {
//        this.q_id = q_id;
//    }
//    public String getQuestion() {
//        return question;
//    }
//    public void setQuestion(String question) {
//        this.question = question;
//    }
//    public Answer getAnswer() {
//        return answer;
//    }
//    public Questions(int q_id, String question, Answer answer) {
//        this.q_id = q_id;
//        this.question = question;
//        this.answer = answer;
//    }
//
//
//
//
//    @Override
//    public String toString() {
//        return "Questions{" +
//                "q_id=" + q_id +
//                ", question='" + question + '\'' +
//                ", answer=" + answer +
//                '}';
//    }
//
//
//}

package org.example.mappingtypes.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.util.ArrayList;
import java.util.List;

@Entity
public class QuestionsOneToMany {
    @Id
    private int q_id;
    private String question;


    public QuestionsOneToMany() {
    }

    @OneToMany(mappedBy = "question")
    private List<AnswersOneToMany> answer = new ArrayList<>();
    public int getQ_id() {
        return q_id;
    }
    public void setQ_id(int q_id) {
        this.q_id = q_id;
    }
    public String getQuestion() {
        return question;
    }
    public void setQuestion(String question) {
        this.question = question;
    }

    public List<AnswersOneToMany> getAnswer() {
        return answer;
    }

    public void setAnswers(List<AnswersOneToMany> answer) {
        this.answer = answer;
    }

    public QuestionsOneToMany(int q_id, String question, List<AnswersOneToMany> answer) {
        this.q_id = q_id;
        this.question = question;
        this.answer = answer;
    }

    @Override
    public String toString() {
        return "Questions{" +
                "q_id=" + q_id +
                ", question='" + question + '\'' +
                ", answer=" + answer +
                '}';
    }
}
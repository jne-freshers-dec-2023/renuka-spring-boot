package org.example.mappingtypes.onetomany;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;


@Entity
public class AnswersOneToMany {
    @Id
    private  int a_id;
    private String ans;

    @ManyToOne
    private QuestionsOneToMany question;

    public QuestionsOneToMany getQuestion() {
        return question;
    }

    public void setQuestion(QuestionsOneToMany question) {
        this.question = question;
    }

    public AnswersOneToMany() {

    }
    public AnswersOneToMany(int a_id, String ans) {
        this.a_id = a_id;
        this.ans = ans;
    }
    public int getA_id() {
        return a_id;
    }

    public void setA_id(int a_id) {
        this.a_id = a_id;
    }

    public String getAns() {
        return ans;
    }

    public void setAns(String ans) {
        this.ans = ans;
    }
    @Override
    public String toString() {
        return "Answer{" +
                "a_id=" + a_id +
                ", ans='" + ans + '\'' +
                '}';
    }
}

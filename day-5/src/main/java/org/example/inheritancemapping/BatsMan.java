package org.example.inheritancemapping;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("batsman")
public class BatsMan extends TeamIndia {
    //@Column(name = "batting_hand")
    private String batting_hand;
    //@Column(name = "highest_score")
    private String highest_score;

    public BatsMan() {
    }

    public String getBatting_hand() {
        return batting_hand;
    }

    public void setBatting_hand(String batting_hand) {
        this.batting_hand = batting_hand;
    }

    public String getHighest_score() {
        return highest_score;
    }

    public void setHighest_score(String highest_score) {
        this.highest_score = highest_score;
    }

    public BatsMan(String batting_hand, String highest_score) {
        this.batting_hand = batting_hand;
        this.highest_score = highest_score;
    }

    @Override
    public String toString() {
        return "BatsMan{" +
                "batting_hand='" + batting_hand + '\'' +
                ", highest_score='" + highest_score + '\'' +
                '}';
    }
}

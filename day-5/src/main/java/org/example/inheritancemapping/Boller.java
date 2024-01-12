package org.example.inheritancemapping;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@DiscriminatorValue("Boller")
public class Boller extends TeamIndia {
    private  String bowler_hand;
    private String best_figure;

    public Boller() {
    }

    public Boller(String bowler_hand, String best_figure) {
        this.bowler_hand = bowler_hand;
        this.best_figure = best_figure;
    }

    public String getBowler_hand() {
        return bowler_hand;
    }

    public void setBowler_hand(String bowler_hand) {
        this.bowler_hand = bowler_hand;
    }

    public String getBest_figure() {
        return best_figure;
    }

    public void setBest_figure(String best_figure) {
        this.best_figure = best_figure;
    }

    @Override
    public String toString() {
        return "Boller{" +
                "bowler_hand='" + bowler_hand + '\'' +
                ", best_figure='" + best_figure + '\'' +
                '}';
    }
}

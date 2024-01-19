package org.example.inheritancemapping;

import javax.persistence.*;

@Entity
@Table(name = "Team_India")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="category",discriminatorType = DiscriminatorType.STRING)
@DiscriminatorValue("staff")
public class TeamIndia {
    @Id
    @GeneratedValue(strategy =GenerationType.AUTO)
    private int playersid;
    private String fname;
    private  String lname;
    public TeamIndia() {
    }
    public String getFname() {
        return fname;
    }

    public int getPlayersid() {
        return playersid;
    }

    public void setPlayersid(int playersid) {
        this.playersid = playersid;
    }

    public TeamIndia(String fname, String lname) {
        this.fname = fname;
        this.lname = lname;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }

    public String getLname() {
        return lname;
    }

    public void setLname(String lname) {
        this.lname = lname;
    }
    @Override
    public String toString() {
        return "TeamIndia{" +
                "playersid=" + playersid +
                ", fname='" + fname + '\'' +
                ", lname='" + lname + '\'' +
                '}';
    }

}

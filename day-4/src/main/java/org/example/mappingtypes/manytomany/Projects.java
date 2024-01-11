package org.example.mappingtypes.manytomany;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
//@Cacheable
//@org.hibernate.annotations.Cache(usage = CacheConcurrencyStrategy.READ_ONLY)
public class Projects {
    @Id
    private int pid;
    private String pname;
    @ManyToMany
    private List<Employees> employees;

    public int getPid() {
        return pid;
    }

    public void setPid(int pid) {
        this.pid = pid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public List<Employees> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employees> employees) {
        this.employees = employees;
    }

    public Projects() {
    }

    public Projects(int pid, String pname, List<Employees> employees) {
        this.pid = pid;
        this.pname = pname;
        this.employees = employees;
    }

    @Override
    public String toString() {
        return "Projects{" +
                "pid=" + pid +
                ", pname='" + pname + '\'' +
                ", employees=" + employees +
                '}';
    }
}

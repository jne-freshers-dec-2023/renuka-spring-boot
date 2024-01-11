package org.example.mappingtypes.manytomany;

import org.hibernate.annotations.CacheConcurrencyStrategy;

import javax.persistence.*;
import java.util.List;

@Entity
@Cacheable
@org.hibernate.annotations.Cache(usage= CacheConcurrencyStrategy.READ_ONLY)
public class Employees {
    @Id
    private  int eid;
    private String ename;
    @ManyToMany//(fetch = FetchType.EAGER)
//    @JoinTable(name = "ProjectsToEmployee",
//            joinColumns = { @JoinColumn(name="eid")},
//            inverseJoinColumns = {@JoinColumn(name = "pid")})
    private List<Projects> projects;

    public Employees() {
    }

    public Employees(int eid, String name, List<Projects> projects) {
        this.eid = eid;
        this.ename = name;
        this.projects = projects;
    }
    public List<Projects> getProjects() {
        return projects;
    }
    public void setProjects(List<Projects> projects) {
        this.projects = projects;
    }
    public int getEid() {
        return eid;
    }
    public void setEid(int eid) {
        this.eid = eid;
    }
    public String getName() {
        return ename;
    }
    public void setName(String name) {
        this.ename = name;
    }

    @Override
    public String toString() {
        return "Employees{" +
                "eid=" + eid +
                ", ename='" + ename + '\'' +
                '}';
    }
//    @Override
//    public String toString() {
//        return "Employees{" +
//                "eid=" + this.eid +
//                ", name='" + this.ename + '\'' +
//                ", projects=" + this.projects +
//                '}';
//    }
}

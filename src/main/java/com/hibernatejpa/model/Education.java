package com.hibernatejpa.model;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
@Entity
@NamedQueries({
        @NamedQuery(name = "Education.findEducations",query = "SELECT e FROM Education e"),
        @NamedQuery(name = "Education.findById",query = "SELECT e FROM Education e WHERE e.educationId=:educationId"),
        @NamedQuery(name = "Education.findWithAdvertisements", query = "SELECT e FROM Education e LEFT JOIN FETCH e.advertisements WHERE e.educationId=:educationId")
})
public class Education implements Serializable {
    private static final long serialVersionUID=1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer educationId;
    private String educationName;
    @ManyToMany(mappedBy = "educations")
    private List<Advertisement> advertisements=new ArrayList<Advertisement>();

    public Education() {
    }

    public Education(String educationName) {
        this.educationName = educationName;
    }

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getEducationId() {
        return educationId;
    }

    public void setEducationId(Integer educationId) {
        this.educationId = educationId;
    }

    public String getEducationName() {
        return educationName;
    }

    public void setEducationName(String educationName) {
        this.educationName = educationName;
    }

    public List<Advertisement> getAdvertisements() {
        return advertisements;
    }

    public void setAdvertisements(List<Advertisement> advertisements) {
        this.advertisements = advertisements;
    }

    @Override
    public String toString() {
        return "Education{" +
                "educationId=" + educationId +
                ", educationName='" + educationName + '\'' +
                ", advertisements=" + advertisements +
                '}';
    }
}

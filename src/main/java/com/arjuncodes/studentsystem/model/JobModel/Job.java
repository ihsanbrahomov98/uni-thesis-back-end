package com.arjuncodes.studentsystem.model.JobModel;
import com.arjuncodes.studentsystem.model.SitterModel.Sitter;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;

@Entity
@Table(name="JOB")
public class Job {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String city;
    private String startingDate;
    private String endingDate;
    private String offeredServices;
    private String telephone;
    private String jobStatus;
    @JsonIgnore
    @ManyToOne
    private Sitter sitter;

    @JsonIgnore
    @ManyToOne
    private Sitter user;

    public Sitter getUser() {
        return user;
    }

    public void setUser(Sitter user) {
        this.user = user;
    }

    public String getTelephone() {
        return telephone;
    }

    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getJobStatus() {
        return jobStatus;
    }

    public void setJobStatus(String jobStatus) {
        this.jobStatus = jobStatus;
    }

    public Sitter getSitter() {
        return sitter;
    }

    public void setSitter(Sitter sitter) {
        this.sitter = sitter;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getStartingDate() {
        return startingDate;
    }

    public void setStartingDate(String startingDate) {
        this.startingDate = startingDate;
    }

    public String getEndingDate() {
        return endingDate;
    }

    public void setEndingDate(String endingDate) {
        this.endingDate = endingDate;
    }

    public String getOfferedServices() {
        return offeredServices;
    }

    public void setOfferedServices(String offeredServices) {
        this.offeredServices = offeredServices;
    }
}

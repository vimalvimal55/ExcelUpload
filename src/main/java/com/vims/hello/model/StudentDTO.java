package com.vims.hello.model;

/**
 * Created by vnatarajan on 06/06/2016.
 */
public class StudentDTO {

    private String id;
    private String name;
    private String emailid;

    public StudentDTO() {}


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmailid() {
        return emailid;
    }

    public void setEmailid(String emailid) {
        this.emailid = emailid;
    }

    @Override
    public String toString() {
        return "StudentDTO{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", emailid='" + emailid + '\'' +
                '}';
    }
}

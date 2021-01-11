package com.acme.graduates.demo.resource;

import javax.validation.constraints.NotNull;

public class SaveGraduateResource {
    @NotNull
    private Integer year;

    @NotNull
    private String sex;

    @NotNull
    private String Course;

    @NotNull
    private  Integer Graduates;

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }


    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public Integer getGraduates() {
        return Graduates;
    }

    public void setGraduates(Integer graduates) {
        Graduates = graduates;
    }
}

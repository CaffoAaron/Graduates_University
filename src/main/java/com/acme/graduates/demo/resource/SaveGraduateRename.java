package com.acme.graduates.demo.resource;

import javax.validation.constraints.NotNull;

public class SaveGraduateRename {
    @NotNull
    private Integer year;

    @NotNull
    private String sex;

    @NotNull
    private String typeCourse;

    @NotNull
    private  Integer noGraduates;

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

    public String getTypeCourse() {
        return typeCourse;
    }

    public void setTypeCourse(String typeCourse) {
        this.typeCourse = typeCourse;
    }

    public Integer getNoGraduates() {
        return noGraduates;
    }

    public void setNoGraduates(Integer noGraduates) {
        this.noGraduates = noGraduates;
    }
}

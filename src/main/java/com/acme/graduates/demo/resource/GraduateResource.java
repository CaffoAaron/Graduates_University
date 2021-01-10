package com.acme.graduates.demo.resource;



public class GraduateResource {
    private Long id;
    private Integer year;
    private String sex;
    private String typeCourse;
    private  Integer noGraduates;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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

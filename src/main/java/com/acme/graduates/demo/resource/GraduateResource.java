package com.acme.graduates.demo.resource;



public class GraduateResource {
    private Long id;
    private Integer year;
    private String sex;
    private String Course;
    private  String Graduates;

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


    public String getCourse() {
        return Course;
    }

    public void setCourse(String course) {
        Course = course;
    }

    public String getGraduates() {
        return Graduates;
    }

    public void setGraduates(String graduates) {
        Graduates = graduates;
    }
}

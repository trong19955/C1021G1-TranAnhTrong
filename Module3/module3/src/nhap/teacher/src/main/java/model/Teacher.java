package model;

public class Teacher {
    private int idTeacher;
    private String nameTeacher;
    private String dateOfBirth;
    private String address;

    public Teacher() {
    }

    public Teacher(int idTeacher, String nameTeacher, String dateOfBirth, String address) {
        this.idTeacher = idTeacher;
        this.nameTeacher = nameTeacher;
        this.dateOfBirth = dateOfBirth;
        this.address = address;
    }

    public int getIdTeacher() {
        return idTeacher;
    }

    public void setIdTeacher(int idTeacher) {
        this.idTeacher = idTeacher;
    }

    public String getNameTeacher() {
        return nameTeacher;
    }

    public void setNameTeacher(String nameTeacher) {
        this.nameTeacher = nameTeacher;
    }

    public String getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(String dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}


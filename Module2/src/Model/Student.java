package Model;

import java.io.Serializable;

public class Student implements Serializable {
    private static final long serialVersionUID = 1l;
    private String studentCode;
    private String studentName;
    private int studentAge;
    private String studentEmail;
    private String studentPhone;
    private String studentAddress;
    private String studentPassword;
    private String schoolYear;

    public Student() {
    }

    public Student(String studentCode, String studentName, int studentAge, String studentEmail, String studentPhone, String studentAddress, String studentPassword, String schoolYear) {
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.studentAge = studentAge;
        this.studentEmail = studentEmail;
        this.studentPhone = studentPhone;
        this.studentAddress = studentAddress;
        this.studentPassword = studentPassword;
        this.schoolYear = schoolYear;
    }

    public String getStudentCode() {
        return studentCode;
    }

    public void setStudentCode(String studentCode) {
        this.studentCode = studentCode;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getStudentAge() {
        return studentAge;
    }

    public void setStudentAge(int studentAge) {
        this.studentAge = studentAge;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
    }

    public String getStudentPhone() {
        return studentPhone;
    }

    public void setStudentPhone(String studentPhone) {
        this.studentPhone = studentPhone;
    }

    public String getStudentAddress() {
        return studentAddress;
    }

    public void setStudentAddress(String studentAddress) {
        this.studentAddress = studentAddress;
    }

    public String getStudentPassword() {
        return studentPassword;
    }

    public void setStudentPassword(String studentPassword) {
        this.studentPassword = studentPassword;
    }

    public String getSchoolYear() {
        return schoolYear;
    }

    public void setSchoolYear(String schoolYear) {
        this.schoolYear = schoolYear;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-25s%-15d%-30s%-15s%-15s%-15s%-15s", this.studentCode, this.studentName, this.studentAge, this.studentEmail, this.studentPhone, this.studentAddress, this.studentPassword, this.schoolYear);
    }
}

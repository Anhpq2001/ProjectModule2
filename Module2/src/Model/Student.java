package Model;

public class Student extends User{
    private String studentEmail;
    private String studentPassword;
    private String schoolYear;

    public Student() {
    }
    public Student(String userCode, String userName, int userAge, String userPhoneNumber, String address, String studentEmail, String studentPassword, String schoolYear) {
        super(userCode, userName, userAge, userPhoneNumber, address);
        this.studentEmail = studentEmail;
        this.studentPassword = studentPassword;
        this.schoolYear = schoolYear;
    }

    public String getStudentEmail() {
        return studentEmail;
    }

    public void setStudentEmail(String studentEmail) {
        this.studentEmail = studentEmail;
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
        return super.toString() + "Student{" +
                "studentEmail='" + studentEmail + '\'' +
                ", studentPassword='" + studentPassword + '\'' +
                ", schoolYear='" + schoolYear + '\'' +
                '}';
    }
}

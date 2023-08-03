package Model;

public class Subject {
    private String subjectCode;
    private String subjectName;
    private Double progressTest1;
    private Double progressTest2;
    private Double projectSubject;
    private boolean status;
    private Student student;

    public Subject() {
    }

    public Subject(String subjectCode, String subjectName, Double progressTest1, Double progressTest2, Double projectSubject, boolean status, Student student) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.progressTest1 = progressTest1;
        this.progressTest2 = progressTest2;
        this.projectSubject = projectSubject;
        this.status = status;
        this.student = student;
    }

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public String getSubjectName() {
        return subjectName;
    }

    public void setSubjectName(String subjectName) {
        this.subjectName = subjectName;
    }

    public Double getProgressTest1() {
        return progressTest1;
    }

    public void setProgressTest1(Double progressTest1) {
        this.progressTest1 = progressTest1;
    }

    public Double getProgressTest2() {
        return progressTest2;
    }

    public void setProgressTest2(Double progressTest2) {
        this.progressTest2 = progressTest2;
    }

    public Double getProjectSubject() {
        return projectSubject;
    }

    public void setProjectSubject(Double projectSubject) {
        this.projectSubject = projectSubject;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", progressTest1=" + progressTest1 +
                ", progressTest2=" + progressTest2 +
                ", projectSubject=" + projectSubject +
                ", status=" + status +
                ", student=" + student +
                '}';
    }
}

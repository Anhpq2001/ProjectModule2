package Model;

import java.io.Serializable;

public class Subject implements Serializable {
    private static final long serialVersionUID = 1l;
    private String subjectCode;
    private String subjectName;
    private int numberOfSlot;

    public Subject() {
    }

    public Subject(String subjectCode, String subjectName, int numberOfSlot) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
        this.numberOfSlot = numberOfSlot;
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

    public int getNumberOfSlot() {
        return numberOfSlot;
    }

    public void setNumberOfSlot(int numberOfSlot) {
        this.numberOfSlot = numberOfSlot;
    }

    @Override
    public String toString() {
        return "Subject{" +
                "subjectCode='" + subjectCode + '\'' +
                ", subjectName='" + subjectName + '\'' +
                ", numberOfSlot=" + numberOfSlot +
                '}';
    }
}

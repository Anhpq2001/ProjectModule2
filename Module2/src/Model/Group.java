package Model;

import java.io.Serializable;

public class Group implements Serializable {
    private static final long serialVersionUID = 1l;
    private String group;
    private String studentCode;
    private String studentName;
    private String subjectCode;
    private int totalSlot;
    public Group() {
    }

    public Group(String group, String studentCode, String studentName, String subjectCode, int totalSlot) {
        this.group = group;
        this.studentCode = studentCode;
        this.studentName = studentName;
        this.subjectCode = subjectCode;
        this.totalSlot = totalSlot;
    }

    public String getGroup() {
        return group;
    }

    public void setGroup(String group) {
        this.group = group;
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

    public String getSubjectCode() {
        return subjectCode;
    }

    public void setSubjectCode(String subjectCode) {
        this.subjectCode = subjectCode;
    }

    public int getTotalSlot() {
        return totalSlot;
    }

    public void setTotalSlot(int totalSlot) {
        this.totalSlot = totalSlot;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-20s%-25s%-20s%-15d", this.group, this.studentCode, this.studentName, this.subjectCode, this.totalSlot);
    }
}

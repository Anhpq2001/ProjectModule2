package Model;

import java.io.Serializable;

public class GroupPoint extends Group implements Serializable {
    private static final long serialVersionUID = 1l;

    private double progressTest1;
    private double progressTest2;
    private double assignment;

    public GroupPoint() {
    }

    public GroupPoint(double progressTest1, double progressTest2, double assignment) {
        this.progressTest1 = progressTest1;
        this.progressTest2 = progressTest2;
        this.assignment = assignment;
    }

    public GroupPoint(String group, String studentCode,String studentName, String subjectCode, int totalSlot) {
        super(group, studentCode, studentName, subjectCode, totalSlot);
    }
    public GroupPoint(String group, String studentCode,String studentName, String subjectCode, int totalSlot, double progressTest1, double progressTest2, double assignment) {
        super(group, studentCode, studentName, subjectCode, totalSlot);
        this.progressTest1 = progressTest1;
        this.progressTest2 = progressTest2;
        this.assignment = assignment;
    }

    public double getProgressTest1() {
        return progressTest1;
    }

    public void setProgressTest1(double progressTest1) {
        this.progressTest1 = progressTest1;
    }

    public double getProgressTest2() {
        return progressTest2;
    }

    public void setProgressTest2(double progressTest2) {
        this.progressTest2 = progressTest2;
    }

    public double getAssignment() {
        return assignment;
    }

    public void setAssignment(double assignment) {
        this.assignment = assignment;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-20s%-20s%-25s%-25.1f%-25.1f%-25.1f", this.getGroup(), this.getSubjectCode(), this.getStudentCode(), this.getStudentName(), this.progressTest1, this.progressTest2, this.assignment);

    }
}

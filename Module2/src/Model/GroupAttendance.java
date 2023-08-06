package Model;

import jdk.nashorn.internal.objects.NativeJava;

import java.io.Serializable;

public class GroupAttendance extends Group implements Serializable {
    private static final long serialVersionUID = 1l;

    private String statusAttendance;
    private int numberSlot;

    public GroupAttendance() {
    }

    public GroupAttendance(String statusAttendance) {
        this.statusAttendance = statusAttendance;
    }

    public GroupAttendance(String group, String studentCode, String studentName, String subjectCode, int totalSlot, int numberSlot) {
        super(group, studentCode, studentName, subjectCode, totalSlot);
        this.numberSlot = numberSlot;
    }

    public GroupAttendance(String group, String studentCode, String studentName, String subjectCode, int totalSlot, String statusAttendance) {
        super(group, studentCode, studentName, subjectCode, totalSlot);
        this.statusAttendance = statusAttendance;
    }

    public String getStatusAttendance() {
        return statusAttendance;
    }

    public void setStatusAttendance(String statusAttendance) {
        this.statusAttendance = statusAttendance;
    }

    public int getNumberSlot() {
        return numberSlot;
    }

    public void setNumberSlot(int numberSlot) {
        this.numberSlot = numberSlot;
    }

    @Override
    public String toString() {
        return String.format("%-15s%-20s%-20s%-25s%-20s%-15d", this.getGroup(), this.getSubjectCode(), this.getStudentCode(), this.getStudentName(), this.statusAttendance, this.numberSlot);

    }
}

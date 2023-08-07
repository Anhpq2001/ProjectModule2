package Controller.Manage;

import Model.Group;
import Model.GroupAttendance;
import Model.GroupPoint;
import Model.Student;
import Validation.CheckInputValue;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageStudentController {
    Scanner scanner = new Scanner(System.in);
    ManageAdminController manageAdminController = ManageAdminController.getInstance();
    ManageGroupController manageGroupController = ManageGroupController.getInstance();
    List<GroupAttendance> groupAttendances = new ArrayList<>();
    List<GroupPoint> groupPoints = new ArrayList<>();
    List<Group> groups = new ArrayList<>();
    List<Student> students = new ArrayList<>();

    // student menu
    public void studentMenu(String studentCode) {
        int choice;
        do {
            System.out.println("1. View status attendance by subject");
            System.out.println("2. View point by subject");
            System.out.println("3. Number subject studing");
            System.out.println("4. Update personal information");
            System.out.println("Other to back");
            System.out.println("Input your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    groupAttendances = manageGroupController.readGroupAttendance("src/IO/GroupAttendance");
                    displayStatusAttendanceBySubject(groupAttendances, studentCode);
                    break;
                case 2:
                    groupPoints = manageGroupController.readGroupPoint("src/IO/GroupPoint");
                    displayPointBySubject(groupPoints, studentCode);
                    break;
                case 3:
                    groups = manageGroupController.read("src/IO/Group");
                    displayGroupStuding(groups, studentCode);
                    break;
                case 4:
                    students = manageAdminController.read("src/IO/Student");
                    updatePersonalInformation(studentCode);
                    manageAdminController.write(students, "src/IO/Student");
                    break;
            }
        } while (choice >= 1 && choice <= 4);
    }

    // function to display status attendance by subject
    public void displayStatusAttendanceBySubject(List<GroupAttendance> groupAttendances, String studentCode){
        String subjectCode = CheckInputValue.checkString("Subject code:");
        System.out.printf("%-15s%-20s%-20s%-25s%-20s%-15s\n", "Group", "Subject Code","Student Code", "Student Name", "Status Attendance", "Slot");
        for(GroupAttendance groupAttendance : groupAttendances){
            if(subjectCode.equals(groupAttendance.getSubjectCode()) && studentCode.equals(groupAttendance.getStudentCode())){
                System.out.println(groupAttendance);
            }
        }
    }
    // function to display point by subject
    public void displayPointBySubject(List<GroupPoint> groupPoints, String studentCode){
        String subjectCode = CheckInputValue.checkString("Subject code:");
        for(GroupPoint groupPoint : groupPoints){
            if(subjectCode.equals(groupPoint.getSubjectCode()) && studentCode.equals(groupPoint.getStudentCode())){
                System.out.printf("%-15s%-20s%-20s%-25s%-25s%-25s%-25s\n", "Group", "Subject Code","Student Code", "Student Name", "Progress Test 1", "Progress Test 2", "Assigment");
                System.out.println(groupPoint);
            }
        }
    }
    // funtion to display group studing
    public void displayGroupStuding(List<Group> groups, String studentCode){
        System.out.printf("%-15s%-20s%-25s%-20s%-15s\n", "Group", "Student Code", "Student Name", "Subject Code", "Total Slot");
        for(Group group : groups){
            if(studentCode.equals(group.getStudentCode())){
                System.out.println(group);
            }
        }
    }
    public void updatePersonalInformation(String index){
        Student updateObject = manageAdminController.getStudent(index);
        updateObject.setStudentAge(CheckInputValue.checkInt("Age:", 17, 28));
        updateObject.setStudentPhone(CheckInputValue.checkString("Phone:"));
        updateObject.setStudentAddress(CheckInputValue.checkString("Address:"));
        updateObject.setStudentPassword(CheckInputValue.checkString("Password:"));
    }
}

package Controller.Manage;

import Model.Admin;
import Model.Student;

import java.util.ArrayList;
import java.util.List;

public class ManageController {
    ManageStudentController manageStudent = new ManageStudentController();
    ManageAdminController manageAdminController = ManageAdminController.getInstance();
    List<Student> students = manageAdminController.read("src/IO/Student");
    Admin admin = new Admin();
    // home menu
    public void homeMenu(String account, String password){
        if(checkInformationStudent(account, password)){
            manageStudent.studentMenu(findStudentCode(account));
        } else if(account.equals(admin.getAdminEmail()) && password.equals(admin.getAdminPasswork())){
            manageAdminController.adminMenu();
        } else{
            System.out.println("login fail!");
        }
    }

    // check account and password student
    public boolean checkInformationStudent(String account, String password){
        boolean check = false;
        for(Student student : students){
            if(account.equals(student.getStudentEmail()) && password.equals(student.getStudentPassword())){
                check = true;
            }
        }
        return check;
    }
    // find student code of user
    public String findStudentCode(String account){
        String studentCode ="";
        for(Student student : students){
            if(account.equals(student.getStudentEmail())){
                studentCode = student.getStudentCode();
            }
        }
        return studentCode;
    }
}

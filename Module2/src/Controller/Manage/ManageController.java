package Controller.Manage;

import Model.Admin;

public class ManageController {
    ManageStudentController manageStudent = new ManageStudentController();
    ManageAdminController manageAdmin = new ManageAdminController();
    Admin admin = new Admin();
    // home menu
    public void homeMenu(String account, String password){
        if(false/*sinh vien*/){
            manageStudent.studentMenu();
        } else if(account.equals(admin.getAdminEmail()) && password.equals(admin.getAdminPasswork())){
            manageAdmin.adminMenu();
        } else{
            System.out.println("login fail!");
        }
    }
}

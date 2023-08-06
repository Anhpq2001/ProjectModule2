package Controller.Manage;

import Model.Admin;

public class ManageController {
    ManageStudentController manageStudent = new ManageStudentController();
    ManageAdminController manageAdminController = ManageAdminController.getInstance();
    Admin admin = new Admin();
    // home menu
    public void homeMenu(String account, String password){
        if(false/*sinh vien*/){
            manageStudent.studentMenu();
        } else if(account.equals(admin.getAdminEmail()) && password.equals(admin.getAdminPasswork())){
            manageAdminController.adminMenu();
        } else{
            System.out.println("login fail!");
        }
    }

}

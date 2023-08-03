package Controller.Login;

import Controller.Manage.ManageController;

import java.util.Scanner;

public class LoginUserController {
    Scanner scanner = new Scanner(System.in);
    ManageController manage = new ManageController();

    // function to manage login
    public void loginManage(){
        System.out.println("-----Login System Student Manage-----");
        System.out.println("Input your email:");
        String email = scanner.nextLine();
        System.out.println("Input your password:");
        String password = scanner.nextLine();
        manage.homeMenu(email, password);
    }
}

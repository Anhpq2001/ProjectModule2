package Controller.Manage;

import IO.FileIO;
import Model.Student;
import Validation.CheckInputValue;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageAdminController implements FileIO {
    Scanner scanner = new Scanner(System.in);
    List<Student> students = new ArrayList<>();

    // admin menu
    public void adminMenu() {
        boolean check = true;
        while (check) {
            System.out.println("----System Manage For Admin----");
            System.out.println("1. Display all student");
            System.out.println("2. Add new student");
            System.out.println("3. Take attendance for class");
            System.out.println("4. Take point for class");
            System.out.println("5. Input student code to manager student");
            System.out.println("6. Logout");
            int choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    displayAllStudent(students);
                    break;
                case 2:
                    addNewStudent();
                    break;
                case 3:
                    break;
                case 4:
                    break;
                case 5:
                    break;
                case 6:
                    //loginUserController.loginManage();
                    check = false;
                    break;
            }
        }
    }

    // function to display all student
    public void displayAllStudent(List<Student> students){
        for(Student s : students){
            System.out.println(s);
        }
    }

    // function to add new student
    // check HE hay HS 6 so sau tu tang
    public void addNewStudent(){
        System.out.println("---Input new student information---");
        String code = CheckInputValue.checkString("code:");
        String name = CheckInputValue.checkString("name:");
        int age = CheckInputValue.checkInt("age:", 18, 27);
        String email = CheckInputValue.checkString("email:");
        String phone = CheckInputValue.checkString("phone:");
        String address = CheckInputValue.checkString("address:");
        String pass = CheckInputValue.checkString("pass:");
        String group = CheckInputValue.checkString("group:");
        String year = CheckInputValue.checkString("year:");
        Student s = new Student(code, name, age, email, phone, address, pass, group, year);
        students.add(s);
    }

    // function to take attendance for class
    public void takeAttendanceForClass(){

    }

    // function to take point for class
    public void takePointForClass(){

    }

    @Override
    public void write(List list, String path) {

    }

    @Override
    public List read(String path) {
        return null;
    }
}

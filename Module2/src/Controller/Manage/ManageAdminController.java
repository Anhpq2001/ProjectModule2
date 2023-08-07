package Controller.Manage;

import IO.FileIO;
import Model.*;
import Validation.CheckInputValue;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageAdminController implements FileIO, IFunction<Student> {
    private static ManageAdminController manageAdminController = new ManageAdminController();
    private ManageAdminController() {
    }
    public static ManageAdminController getInstance() {
        if(manageAdminController == null){
            manageAdminController = new ManageAdminController();
        }
        return manageAdminController;
    }
    ManageGroupController manageGroupController = ManageGroupController.getInstance();
    Scanner scanner = new Scanner(System.in);
    List<Student> students = new ArrayList<>();
    List<Subject> subjects = new ArrayList<>();
    List<GroupPoint> groupPoints = new ArrayList<>();
    List<GroupAttendance> groupAttendances = new ArrayList<>();
    List<Group> groups = new ArrayList<>();

    // admin menu
    public void adminMenu() {
        int choice;
        do {
            System.out.println("----System Manage For Admin----");
            System.out.println("1. Display all information subject in system");
            System.out.println("2. Add new student");
            System.out.println("3. Take attendance for class");
            System.out.println("4. Take point for class");
            System.out.println("5. Input student code to manager student");
            System.out.println("Other to back");
            System.out.println("Input your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    students = read("src/IO/Student");
                    displayItem(students);
                    System.out.println("");
                    groups = manageGroupController.read("src/IO/Group");
                    manageGroupController.displayItem(groups);
                    System.out.println("");
                    groupAttendances = manageGroupController.readGroupAttendance("src/IO/GroupAttendance");
                    displayGroupAttendamce(groupAttendances);
                    System.out.println("");
                    groupPoints = manageGroupController.readGroupPoint("src/IO/GroupPoint");
                    displayGroupPoint(groupPoints);
                    break;
                case 2:
                    students = read("src/IO/Student");
                    insertItem("");
                    write(students, "src/IO/Student");
                    break;
                case 3:
                    groupAttendances = manageGroupController.readGroupAttendance("src/IO/GroupAttendance");
                    takeAttendanceForClass();
                    manageGroupController.write(groupAttendances, "src/IO/GroupAttendance");
                    break;
                case 4:
                    groupPoints = manageGroupController.readGroupPoint("src/IO/GroupPoint");
                    takePointForClass();
                    manageGroupController.write(groupPoints, "src/IO/GroupPoint");
                    break;
                case 5:
                    students = read("src/IO/Student");
                    String check = findItemID();
                    if (!check.isEmpty()) {
                        optionPlusForAdmin(check);
                    } else {
                        System.out.println("Not found!");
                    }
                    break;
            }
        } while (choice >= 1 && choice <= 5);
    }

    public void optionPlusForAdmin(String check) {
        int choice;
        do {
            System.out.println("---Options Plus For Admin---");
            System.out.println("1. Course registration");
            System.out.println("2. Cancel course registration");
            System.out.println("3. Remove student don't study in campus");
            System.out.println("4. Update information student in campus");
            System.out.println("Other to back");
            System.out.println("Input your choice:");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    groupAttendances = manageGroupController.readGroupAttendance("src/IO/GroupAttendance");
                    groupPoints = manageGroupController.readGroupPoint("src/IO/GroupPoint");
                    groups = manageGroupController.read("src/IO/Group");
                    manageGroupController.insertItem(check);
                    manageGroupController.write(groups,"src/IO/Group");
                    manageGroupController.write(groupAttendances, "src/IO/GroupAttendance");
                    manageGroupController.write(groupPoints,"src/IO/GroupPoint");
                    break;
                case 2:
                    groupAttendances = manageGroupController.readGroupAttendance("src/IO/GroupAttendance");
                    groupPoints = manageGroupController.readGroupPoint("src/IO/GroupPoint");
                    groups = manageGroupController.read("src/IO/Group");
                    manageGroupController.removeItem(check);
                    manageGroupController.write(groups,"src/IO/Group");
                    manageGroupController.write(groupAttendances, "src/IO/GroupAttendance");
                    manageGroupController.write(groupPoints,"src/IO/GroupPoint");
                    break;
                case 3:
                    students = read("src/IO/Student");
                    removeItem(check);
                    write(students, "src/IO/Student");
                    break;
                case 4:
                    students = read("src/IO/Student");
                    updateItem(check);
                    write(students, "src/IO/Student");
                    break;
            }
        } while (choice >= 1 && choice <= 4);
    }

    //function get subject
    public Student getStudent(String code) {
        Student obj = new Student();
        for (Student s : students) {
            if (code.equals(s.getStudentCode())) {
                obj = s;
            }
        }
        return obj;
    }

    // function to take attendance for class
    public void takeAttendanceForClass() {
        String group = CheckInputValue.checkString("Group:");
        String subjectCode = CheckInputValue.checkString("Subject code:");
        int numberSlot = CheckInputValue.checkInt("Slot:", 0, 31);
        for(GroupAttendance groupAttendance : groupAttendances){
            if(group.equals(groupAttendance.getGroup()) && (numberSlot == groupAttendance.getNumberSlot()) && subjectCode.equals(groupAttendance.getSubjectCode())){
                System.out.print(groupAttendance.getStudentCode() + "     " + groupAttendance.getStudentName() + "     ");
                groupAttendance.setStatusAttendance(CheckInputValue.getYesNo("yes(Attend)/no(Absent): "));
            }
        }
    }

    // function to take point for class
    public void takePointForClass() {
        String group = CheckInputValue.checkString("Group:");
        String subjectCode = CheckInputValue.checkString("Subject code:");
        for(GroupPoint groupPoint : groupPoints){
            if(group.equals(groupPoint.getGroup()) && subjectCode.equals(groupPoint.getSubjectCode())) {
                System.out.print(groupPoint.getStudentCode() + "     " + groupPoint.getStudentName() + "\n");
                groupPoint.setProgressTest1(CheckInputValue.checkDouble("Enter progress test 1 point:", -1, 11));
                groupPoint.setProgressTest2(CheckInputValue.checkDouble("Enter progress test 2 point:", -1, 11));
                groupPoint.setAssignment(CheckInputValue.checkDouble("Enter assignment point:", -1, 11));
            }
        }
    }

    @Override
    public void write(List list, String path) {
        FileOutputStream fos = null;
        ObjectOutputStream oos = null;
        try {
            fos = new FileOutputStream(path);
            oos = new ObjectOutputStream(fos);
            oos.writeObject(list);
            System.out.println("Save in file successfully!");
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fos != null) {
                try {
                    fos.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }

    @Override
    public List<Student> read(String path) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            students = (List<Student>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
        return students;
    }

    @Override
    public void insertItem(String index) {
        // admin nhap vao ma nganh con 6 so phia sau tu tang
        System.out.println("---Input new student information---");
        String code = CheckInputValue.checkString("code:"); // chua check regex
        String name = CheckInputValue.checkString("name:");
        int age = CheckInputValue.checkInt("age:", 18, 27);
        String email = CheckInputValue.checkString("email:"); // chua check regex email
        String phone = CheckInputValue.checkString("phone:"); // chua check regex phone number
        String address = CheckInputValue.checkString("address:");
        String pass = CheckInputValue.checkString("pass:");
        String year = CheckInputValue.checkString("year:");
        Student s = new Student(code, name, age, email, phone, address, pass, year);
        students.add(s);
    }

    @Override
    public void removeItem(String index) {
        // chi thuc hien xoa chu khong kiem tra ma code student nua
        // khi xoa student thi xoa not cac record lien qua den student do trong group
        String check;
        Student deleteObject = getStudent(index);
        check = CheckInputValue.getYesNo("Are you sure you want to delete (Yes/No)? ");
        if (check.equalsIgnoreCase("Yes")) {
            students.remove(deleteObject);
            System.out.println("Success!");
        } else {
            System.out.println("Fail!");
        }

    }

    @Override
    public void updateItem(String index) {
        Student updateObject = getStudent(index);
        updateObject.setStudentAge(CheckInputValue.checkInt("Age:", 17, 28));
        updateObject.setStudentPhone(CheckInputValue.checkString("Phone:"));
        updateObject.setStudentAddress(CheckInputValue.checkString("Address:"));
        updateObject.setStudentPassword(CheckInputValue.checkString("Password:"));
    }

    @Override
    public void displayItem(List<Student> students) {
        System.out.println("--Detail Information Students--");
        System.out.printf("%-15s%-25s%-15s%-30s%-15s%-15s%-15s%-15s\n", "StudentCode", "Name", "Age", "Email", "Phone", "Address", "Password", "YearNumber");
        for (Student s : students) {
            System.out.println(s);
        }
    }

    @Override
    public String findItemID() {
        String code = CheckInputValue.checkString("Enter student code to more choice option:");
        String result = "";
        for (Student s : students) {
            if (code.equals(s.getStudentCode())) {
                result = code;
            }
        }
        return result;
    }
    public void readSubject(String path){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            subjects = (List<Subject>) ois.readObject();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            if (ois != null) {
                try {
                    ois.close();
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        }
    }
/*    public void addSubject(){
        System.out.println("nhap mon moi");
        String subjectCode = CheckInputValue.checkString("nhap ma mon:");
        String subjectName = CheckInputValue.checkString("nhap ten mon:");
        int numberOfSlot = CheckInputValue.checkInt("nhap so buoi", 0, 31);
        subjects.add(new Subject(subjectCode, subjectName, numberOfSlot));
    }

    }*/

    public void displayGroupAttendamce(List<GroupAttendance> groupAttendances){
        System.out.println("--Detail Information Group Attendance--");
        System.out.printf("%-15s%-20s%-20s%-25s%-20s%-15s\n", "Group", "Subject Code","Student Code", "Student Name", "Status Attendance", "Slot");
        for(Group g: groupAttendances){
            System.out.println(g);
        }
    }
    public void displayGroupPoint(List<GroupPoint> groupPoints){
        System.out.println("--Detail Information Group Point--");
        System.out.printf("%-15s%-20s%-20s%-25s%-25s%-25s%-25s\n", "Group", "Subject Code","Student Code", "Student Name", "Progress Test 1", "Progress Test 2", "Assigment");
        for(Group g: groupPoints){
            System.out.println(g);
        }
    }
}

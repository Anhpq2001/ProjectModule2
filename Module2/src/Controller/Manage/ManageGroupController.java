package Controller.Manage;

import IO.FileIO;
import Model.*;
import Validation.CheckInputValue;
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageGroupController implements FileIO<Group>, IFunction<Group>{
    private static ManageGroupController manageGroupController = new ManageGroupController();
    private ManageGroupController() {
    }
    public static ManageGroupController getInstance() {
        /*if(manageGroupController == null){
            manageGroupController = new ManageGroupController();
        }*/
        return manageGroupController;
    }
    ManageAdminController manageAdminController = ManageAdminController.getInstance();
    Scanner scanner = new Scanner(System.in);
    List<Group> groups = new ArrayList<>();
    List<GroupPoint> groupPoints = new ArrayList<>();
    List<GroupAttendance> groupAttendances = new ArrayList<>();
    List<Student> students = new ArrayList<>();
    List<Subject> subjects = new ArrayList<>();



    @Override
    public void insertItem(String index) {
        manageAdminController.read("src/IO/Student");
        manageAdminController.readSubject("src/IO/Subject");
        Student s = manageAdminController.getStudent(index);
        System.out.println("---Registration group for student");
        String groupName = CheckInputValue.checkString("Group:");
        String studentCode = index;
        String studentName = s.getStudentName();
        String subjectCode = CheckInputValue.checkString("Subject code:");
        int totalSlot = CheckInputValue.checkInt("Total slot:", 0, 31);
        Group group = new Group(groupName, studentCode, studentName,subjectCode, totalSlot);
        GroupPoint groupPoint = new GroupPoint(groupName, studentCode, studentName, subjectCode, totalSlot);
        groups.add(group);
        groupPoints.add(groupPoint);
        for(int i = 1; i<=totalSlot; i++){
            GroupAttendance groupAttendance= new GroupAttendance(groupName, studentCode, studentName, subjectCode, totalSlot, i);
            groupAttendances.add(groupAttendance);
        }
    }

    @Override
    public void removeItem(String index) {

    }

    @Override
    public void updateItem(String index) {

    }

    @Override
    public void displayItem(List<Group> itemList) {

    }

    @Override
    public String findItemID() {
        return null;
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
    public List<Group> read(String path) {
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            groups = (List<Group>) ois.readObject();
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
        return groups;
    }
    public List<GroupPoint> readGroupPoint(String path){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            groupPoints = (List<GroupPoint>) ois.readObject();
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
        return groupPoints;
    }
    public List<GroupAttendance> readGroupAttendance(String path){
        FileInputStream fis = null;
        ObjectInputStream ois = null;
        try {
            fis = new FileInputStream(path);
            ois = new ObjectInputStream(fis);
            groupAttendances = (List<GroupAttendance>) ois.readObject();
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
        return groupAttendances;
    }
}

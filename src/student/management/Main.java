package student.management;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {
        StudentManager stdMng = new StudentManager();
        List<Student> students = stdMng.getStudents();
        Scanner input = new Scanner(System.in);
        boolean check = true;
        while (check) {

            System.out.println("========MENU=========");
            System.out.println("1. Add student");
            System.out.println("2. Find the student by ID");
            System.out.println("3. Find the student by name");
            System.out.println("4. Remove the student");
            System.out.println("5. Write the student list to the binary file");
            System.out.println("6. Write the student list to the text file");
            System.out.println("7. Read the student list from the binary file");
            System.out.println("8. Read the student list from the text file");
            System.out.println("9. Display all list");
            System.out.println("10. Exit ");
            System.out.println("Enter your option:");
            int option = input.nextInt();
            switch (option) {
                case 1:
                    input.nextLine();
                    while (true) {
                        try {
                            System.out.println("Name of the student:");
                            String name = input.nextLine();
                            System.out.println("Age of the student:");
                            int age = input.nextInt();
                            System.out.println("ID of the student:");
                            String ID = input.next();
                            stdMng.addStudent(new Student(name, age, ID));
                            System.out.println("Add successfully");
                            break;
                        } catch (InputMismatchException ex) {
                            input.nextLine();
                            System.out.println("Input mismatch, try again");
                        }
                    }
                    break;
                case 2:
                    input.nextLine();
                    System.out.println("Enter ID of the student:");
                    String findID = input.next();
                    Student std = stdMng.findStudentByID(findID);
                    if (std != null) {
                        System.out.println(std.toString());
                    } else {
                        System.out.println("No such this student");
                    }
                    break;
                case 3:
                    input.nextLine();
                    System.out.println("Enter name of the student:");
                    String findName = input.nextLine();
                    List<Student> findStdList = stdMng.findStudentByName(findName);
                    if (findStdList != null) {
                        for (Student searchedStd : findStdList) {
                            System.out.println(searchedStd.toString());
                        }
                    } else {
                        System.out.println("Could not foundl");
                    }

                    break;
                case 4:
                    input.nextLine();
                    System.out.println("Enter ID of the student");
                    String removedID = input.next();
                    if (stdMng.removeStudent(removedID)) {
                        System.out.println("Remove successfully");
                    } else {
                        System.out.println("Remove NOT successfully");
                    }
                    break;
                case 5:
                    try {
                        StudentDataAccess.writeToBinaryFile(students);
                        System.out.println("Successfully");
                    } catch (IOException ex) {
                        System.out.println("IO exception");
                    }
                    break;
                case 6:
                    try {
                        StudentDataAccess.writeToTextFile(students);
                        System.out.println("Successfully");
                    } catch (IOException ex) {
                        System.out.println("IO exception");
                    }
                    break;
                case 7:
                    try {
                        StudentDataAccess.readFromBinaryFile("Binary.txt");
                    } catch (ClassNotFoundException e) {
                        e.printStackTrace();
                    } catch (FileNotFoundException ex) {
                        System.out.println("No such filel");
                    }
                    break;
                case 8:
                    try {
                        List<Student> readStudentList = StudentDataAccess.readFromTextFile("StudentList.txt");
                        if (readStudentList != null) {
                            for (Student readStd : readStudentList) {
                                System.out.println(readStd.toString());
                            }
                        } else {
                            System.out.println("No student");
                        }
                    } catch (FileNotFoundException ex) {
                        System.out.println("No such file");
                    } catch (UnsupportedEncodingException ex) {
                        System.out.println("UnsupportedEncodingException");
                    }
                    break;
                case 9:
                    stdMng.disp();
                    break;
                case 10:
                    System.out.println("Exit");
                    check = false;
                    break;
                default:
                    System.out.println("No such case, try again");
                    break;
            }
        }

    }
}

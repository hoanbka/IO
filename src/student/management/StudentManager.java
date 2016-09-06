package student.management;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class StudentManager {

    public List<Student> students = getFile();

    private List<Student> getFile() {
        try {
            List<Student> students = StudentDataAccess.readFromTextFile("StudentList.txt");
            if (students.isEmpty()) {
                return new ArrayList<>();
            }
            return students;

        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student std) {

        if ((std.getID().length() == 0) || (std.getName().length() == 0) || (std.getAge() <= 0)
                || (isStudentExisted(std.getID()))) {
            return false;
        }
        return students.add(std);
    }

    public Student findStudentByID(String ID) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID().equals(ID)) {
                return students.get(i);
            }
        }
        return null;
    }

    private boolean isStudentExisted(String ID) {
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID().equals(ID)) {
                return true;
            }
        }
        return false;
    }

    public List<Student> findStudentByName(String stdName) {
        List<Student> stdList = new ArrayList<>();
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getName().equals(stdName)) {
                stdList.add(students.get(i));
            }
        }
        return stdList;
    }

    public boolean removeStudent(String ID) {
        if (findStudentByID(ID) == null) {
            return false;
        }
        for (int i = 0; i < students.size(); i++) {
            if (students.get(i).getID().equals(ID)) {
                students.remove(students.get(i));
                return true;
            }
        }
        return false;
    }

    public void disp() {
        for (Student student : students) {
            System.out.println(student.toString());
        }
    }
}

package student.management;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class StudentManager {
    private List<Student> students = new ArrayList<Student>();

    public List<Student> getStudents() {
        return students;
    }

    public boolean addStudent(Student std) {

        if (findStudentByID(std.getID()) != null) {
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

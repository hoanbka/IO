package student.management;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Student std1 = new Student("Nguyễn Văn Hoan", 24, "1234");
        Student std2 = new Student("Phạm Văn Hưng", 25, "AB23");

        StudentManager stdMng = new StudentManager();
        List<Student> students = stdMng.getStudents();

    }
}

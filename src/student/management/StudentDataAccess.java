package student.management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class StudentDataAccess {

    public static void writeToBinaryFile(List<Student> studentList) throws IOException {
        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Binary.txt", true));
        objectOutputStream.writeObject(studentList);
        objectOutputStream.flush();
        objectOutputStream.close();
    }

    public static void readFromBinaryFile(String path) throws IOException, ClassNotFoundException {
        ObjectInputStream objctInputStream = new ObjectInputStream(new FileInputStream(path));
        List<Student> studentList = (List<Student>) objctInputStream.readObject();

        for (Student std : studentList) {
            System.out.println(std.toString());
        }
        objctInputStream.close();
    }

    public static void writeToTextFile(List<Student> studentList) throws FileNotFoundException, UnsupportedEncodingException {
        try {
            PrintWriter writer = new PrintWriter("StudentList.txt", "UTF-8");
            for (Student stdList : studentList
                    ) {
                writer.println(stdList.toString());
            }
            writer.close();
        } catch (FileNotFoundException ex) {
            System.out.println();
        }
    }

    public static List<Student> readFromTextFile(String path) throws IOException {
        List<Student> students = new ArrayList<>();
        File file = new File(path);

        BufferedReader inputStream = new BufferedReader(new FileReader(file));
        String line;
        while ((line = inputStream.readLine()) != null) {
            String splitted[] = line.split(";");
            String name = splitted[0];
            int age = Integer.parseInt(splitted[1]);
            String ID = splitted[2];
            students.add(new Student(name, age, ID));
        }
        return students;
    }


}

package student.management;

import java.io.*;
import java.util.ArrayList;
import java.util.List;


public class StudentDataAccess {

    public static void writeToBinaryFile(List<Student> studentList) throws IOException {

        ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Binary.txt", true));
        try {
            objectOutputStream.writeObject(studentList);
            objectOutputStream.flush();

        } finally {
            objectOutputStream.close();
        }

    }

    public static void writeToBinaryFile2(List<Student> studentList) throws IOException {

        try (ObjectOutputStream objectOutputStream = new ObjectOutputStream(new FileOutputStream("Binary.txt", true))) {
            objectOutputStream.writeObject(studentList);
            objectOutputStream.flush();
        }

    }

    public static void readFromBinaryFile(String path) throws IOException, ClassNotFoundException {
        try (ObjectInputStream objctInputStream = new ObjectInputStream(new FileInputStream(path))) {

            List<Student> studentList = (List<Student>) objctInputStream.readObject();

            for (Student std : studentList) {
                System.out.println(std.toString());
            }
        }
    }

    public static void writeToTextFile(List<Student> studentList) throws FileNotFoundException, UnsupportedEncodingException {

        PrintWriter writer = new PrintWriter("StudentList.txt", "UTF-8");
        try {

            for (Student stdList : studentList) {
                writer.println(stdList.toString());
            }

        } finally {
            writer.close();
        }
    }

    public static List<Student> readFromTextFile(String path) throws IOException {
        List<Student> students = new ArrayList<>();
        File file = new File(path);

        try (BufferedReader inputStream = new BufferedReader(new FileReader(file))) {
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


}

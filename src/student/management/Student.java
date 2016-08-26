package student.management;

import java.io.Serializable;

public class Student implements Serializable{
    private String name;
    private int age;
    private String ID;

    public Student(String name, int age, String ID) {
        this.name = name;
        this.age = age;
        this.ID = ID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    @Override
    public String toString() {
        return this.name+";"+this.age+";"+ this.ID;
    }
}

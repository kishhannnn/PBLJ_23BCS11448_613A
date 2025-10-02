package Demo;
import java.io.*;

class Student implements Serializable {
    private static final long serialVersionUID = 1L;
    private int studentID;
    private String name;
    private String grade;

    public Student(int studentID, String name, String grade) {
        this.studentID = studentID;
        this.name = name;
        this.grade = grade;
    }

    public void display() {
        System.out.println("Student ID: " + studentID);
        System.out.println("Name: " + name);
        System.out.println("Grade: " + grade);
    }
}

public class PartB {
    public static void main(String[] args) {
        String filename = "student.ser";

        try (ObjectOutputStream out = new ObjectOutputStream(new FileOutputStream(filename))) {
            Student student = new Student(101, "Abc", "A");
            out.writeObject(student);
            System.out.println("Student object serialized and saved to " + filename);
        } catch (IOException e) {
            e.printStackTrace();
        }

        try (ObjectInputStream in = new ObjectInputStream(new FileInputStream(filename))) {
            Student deserializedStudent = (Student) in.readObject();
            System.out.println("Student object deserialized successfully.");
            deserializedStudent.display();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}

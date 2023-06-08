import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        
        StudentDatabase.students = new Student[3];
        Scanner in = new Scanner(System.in);
        System.out.println("Enter student's 1 data: ");
        StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt()); //it leaves an "\n" that is captured by the next nextLine()
        in.nextLine();
        System.out.println("Enter student's 2 data: ");
        StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
        in.nextLine();
        System.out.println("Enter student's 3 data: ");
        StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
        in.nextLine();
        System.out.println("Enter student's 4 data: ");
        StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
        in.nextLine();
        StudentDatabase.printAllStudents();
    }
}

class StudentDatabase {
    public static Student[] students;
    public static int lastIndex = 0;

    public static void addStudent(String fullName, String groupName, int generalGrade) {
        if (lastIndex != students.length) {
            students[lastIndex] = new Student(fullName, groupName, generalGrade);
            lastIndex++;
        } else if (lastIndex == students.length) {
            System.err.println("Warrning! Only " + students.length + " students can be stored!");
        }
    }

    public static void printAllStudents() {
        System.out.println("\n\nSTUDENT LIST: ");
        for (Student student : students) {
            if (student == null) {      //<--cannot use here .equals, it doesn't work when "student" is null, but "==" is fine.
                
            } else {
                System.out.println(student);
            }
        }
    }
}

class Student {

    private String fullName;
    private String groupName;
    private int generalGrade;

    public Student(String fullName, String groupName, int generalGrade) {
        this.fullName = fullName;
        this.groupName = groupName;
        this.generalGrade = generalGrade;
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getGroupName() {
        return groupName;
    }

    public void setGroupName(String groupName) {
        this.groupName = groupName;
    }

    public int getGeneralGrade() {
        return generalGrade;
    }

    public void setGeneralGrade(int generalGrade) {
        this.generalGrade = generalGrade;
    }

    @Override
    public String toString() {
        return "Student [fullName=" + fullName + ", groupName=" + groupName + ", generalGrade=" + generalGrade + "]";
    }

}

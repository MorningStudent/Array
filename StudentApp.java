import java.util.Scanner;

public class StudentApp {
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        StudentDatabase.students = new Student[4];
        int option;
        while (true) {
            option = ConsoleUI.printMenu();
            switch (option) {
                case 1: StudentDatabase.printAllStudents(); break;
                case 2: System.out.println("Enter student's Full Name, Group Name, General Grade to be added: ");
                        StudentDatabase.addStudent(in.nextLine(), in.nextLine(), in.nextInt());
                        in.nextLine(); break;
                case 3: System.out.println("Enter student's Full Name, Group Name, General Grade, Index to be updated: ");
                        StudentDatabase.updateStudent(in.nextLine(), in.nextLine(), in.nextInt(), in.nextInt());
                        in.nextLine(); break;
                case 4: System.out.println("Enter student's Index to be deleted: ");
                        StudentDatabase.deleteStudent(in.nextInt());
                        in.nextLine(); break;
                default: System.out.println("No such option!");
            }
        }
    }
}

class ConsoleUI {
    public static int printMenu() {
        System.out.println("MENU");
        System.out.println("1. To view students list\n2. To add student\n3. To update student\n4. To delete student");
        System.out.print(">> ");
        Scanner in = new Scanner(System.in);
        int option = in.nextInt();
        return option;
    }
}

class StudentDatabase {
    public static Student[] students;
    public static int lastIndex = 0;

    public static void addStudent(String fullName, String groupName, int generalGrade) {
        Student[] newStudents = new Student[students.length+1];
        for (int i=0, j=0; i<students.length; i++, j++) {
            newStudents[j] = students[i];
        }
        students = newStudents;
        students[lastIndex] = new Student(fullName, groupName, generalGrade);
        lastIndex++;
    }

    public static void printAllStudents() {
        System.out.println("\n\nSTUDENT LIST: ");
        for (Student student : students) {
            if (student == null) {    
                
            } else {
                System.out.println(student);
            }
        }
    }

    public static void updateStudent(String fullName, String groupName, int generalGrade, int index) {
        students[index].setFullName(fullName);
        students[index].setGroupName(groupName);
        students[index].setGeneralGrade(generalGrade);
    }

    public static void updateStudent(String fullName, String groupName, int index) {
        students[index].setFullName(fullName);
        students[index].setGroupName(groupName);
    }

    public static void updateStudent(String fullName, int index) {
        students[index].setFullName(fullName);
    }

    public static void updateStudent(int index, int generalGrade) {
        students[index].setGeneralGrade(generalGrade);
    }

    public static void deleteStudent(int index) {
        Student[] newStudents = new Student[students.length-1];
        for (int i=0, j=0; i<students.length; i++) {
            if (i != index) {
                newStudents[j++] = students[i];
            }
        }
        students = newStudents;
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

package main;
import student.Student;

import java.util.ArrayList;
import java.util.Objects;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ArrayList<Student> students = new ArrayList<>();
        students = createStudentArray();

        showStudentsByFaculty(students, "CS");
        showStudentsByBirthday(students, 2002);
        showStudentsByGroup(students, "KN-205");
    }

    static ArrayList<Student> createStudentArray(){
        ArrayList<Student> students = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        Scanner scan2 = new Scanner(System.in);
        boolean isContinue = true;
        do{
            System.out.print("Enter id: ");
            int id = scan.nextInt();
            System.out.print("Enter FirstName: ");
            String FirstName = scan2.nextLine();
            System.out.print("Enter LastName: ");
            String LastName = scan2.nextLine();
            System.out.print("Enter MiddleName: ");
            String MiddleName = scan2.nextLine();
            System.out.print("Enter birthday: ");
            String birthday = scan2.nextLine();
            System.out.print("Enter address: ");
            String address = scan2.nextLine();
            System.out.print("Enter mobile: ");
            int mobile = scan.nextInt();
            System.out.print("Enter faculty: ");
            String faculty = scan2.nextLine();
            System.out.print("Enter course: ");
            int course = scan.nextInt();
            System.out.print("Enter group: ");
            String group = scan2.nextLine();

            Student student  = new Student(id, FirstName,LastName, MiddleName, birthday,address,mobile,faculty,course,group);
            students.add(student);
            System.out.println("Would You like to enter the next one(true/false)?");
            isContinue = scan.nextBoolean();
        }while (isContinue);
        return students;
    }
    static void showStudents(ArrayList<Student> students){
        for (Student student: students) {
            System.out.println(student);
        }
    }
    static void showStudentsByFaculty(ArrayList<Student> students, String faculty){
        System.out.printf("The students of %s :%n", faculty);
        for (Student student: students) {
            if(Objects.equals(student.getFaculty(), faculty)){
                System.out.println(student);
            }
        }
        System.out.println("\n");
    }

    static void showStudentsByBirthday(ArrayList<Student> students, int year){
        System.out.printf("The students who born after %d :%n", year);
        for (Student student: students) {
            String[] str = student.getBirthday().split("/");
            int year1 = Integer.parseInt(str[2]);
            if(year1 > year){
                System.out.println(student);
            }
        }
        System.out.println("\n");
    }

    static void showStudentsByGroup(ArrayList<Student> students, String group){
        System.out.printf("The students of %s :%n", group);
        for (Student student: students) {
            if(Objects.equals(student.getGroup(), group)){
                System.out.println(student);
            }
        }
        System.out.println("\n");
    }
}


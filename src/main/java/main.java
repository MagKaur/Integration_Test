import javax.persistence.*;
import java.util.Scanner;


class integration_test {

    public static void main(String[] args){

        test_aeh_students student = new test_aeh_students();
        studentService service = new studentService(student);
        //Searching for student by name
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        getStudent s = new getStudent(sc.nextLine());
        s.getStudentVariable()*/

        //Adding student to database
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name and surname: ");
        String nazwaWpisana = scanner.nextLine();
        service.przypiszDane(nazwaWpisana);
        service.addStudent();

        //addStudent add = new addStudent(a.nextLine());
        //add.assign();
        //add.addStudent();


    }
}

import javax.persistence.*;
import java.util.Scanner;


class integration_test {

    public static void main(String[] args){

        test_aeh_students student = new test_aeh_students();
        studentService service = new studentService(student);

        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter name and surname: ");
        String nazwaWpisana = scanner.nextLine();
        service.przypiszDane(nazwaWpisana);
        //Adding student to database
        service.addStudent();
        service.getStudent();
    }
}

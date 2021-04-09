import javax.persistence.*;
import java.util.Scanner;


class integration_test {

    public static void main(String[] args){


        //Searching for student by name
        /*Scanner sc = new Scanner(System.in);
        System.out.println("Enter name: ");
        getStudent s = new getStudent(sc.nextLine());
        s.getStudentVariable*/

        //Adding student to database
        Scanner a = new Scanner(System.in);
        System.out.println("Enter name and surname: ");
        addStudent add = new addStudent(a.nextLine());
        add.assign();
        add.addStudent();


    }
}

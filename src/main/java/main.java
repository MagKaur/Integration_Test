import javax.persistence.*;
import java.util.Scanner;


class integration_test {

    public static void main(String[] args){

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter numbers: ");
        query searchname = new query(sc.nextLine());
        searchname.getStudentVariable();
        //query get = new query();
        //get.getStudent();

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory ("Integration_Test");

        test_aeh_students test = new test_aeh_students();

        test.setId(2);
        test.setName("Jan");
        test.setSurname("Kowalski");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(test);
        entityManager.getTransaction().commit();

        entityManager.close();

    }
}

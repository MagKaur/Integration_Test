import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class addStudent {

    test_aeh_students test = new test_aeh_students();

    private String data;
    private String addName;
    private String addSurname;



    public addStudent (String text) {
        this.data = text;
    }

    public void assign(){
      addName = data.split(" ")[0];
      addSurname = data.split(" ")[1];
    }

    public void addStudent(){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory ("Integration_Test");

        test.setId();
        test.setName(addName);
        test.setSurname(addSurname);

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

        entityManager.merge(test);
        entityManager.getTransaction().commit();

        entityManager.close();
    }

}

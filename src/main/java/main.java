import javax.persistence.*;

class integration_test {

    public static void main(String[] args){

        EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Integration_Test");

            test_aeh_students test = new test_aeh_students();

            test.setId(1);
            test.setName("Jan");
            test.setSurname("Kowalski");

        EntityManager entityManager = entityManagerFactory.createEntityManager();

        entityManager.getTransaction().begin();

            entityManager.persist(test);
            entityManager.getTransaction().commit();

        entityManager.close();

    }
}
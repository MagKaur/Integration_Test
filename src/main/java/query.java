import javax.persistence.*;


public class query {

    //test_aeh_students student = new test_aeh_students();
    String newname;

    public query(String newname) {this.newname = newname;}

    @PersistenceUnit
    EntityManagerFactory em = Persistence.createEntityManagerFactory("Integration_Test");

    public void getStudent() {

        EntityManager m = em.createEntityManager();


        test_aeh_students query_result = (test_aeh_students) m.createQuery("SELECT c FROM test_aeh_students c where c.name = 'Jan' ")
                .getSingleResult();
        System.out.println ("List of all customers: "+ query_result);
    }

    //TODO sql query ze zmienną
    //TODO wyświetlanie porządne wyniku - teraz bez ładnych odstępów
    public void getStudentVariable (String newname){

        EntityManager m = em.createEntityManager();


        test_aeh_students query_result = (test_aeh_students) m.createQuery("SELECT c FROM test_aeh_students c where c.name = )
                .getSingleResult();
        System.out.println ("List of all customers: "+ query_result);
    }

    }


}




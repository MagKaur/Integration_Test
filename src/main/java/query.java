import javax.persistence.*;


public class query {

    String newname;

    public query(String text) {this.newname = text;}

    @PersistenceUnit
    EntityManagerFactory em = Persistence.createEntityManagerFactory("Integration_Test");

    /*public void getStudent() {

        EntityManager m = em.createEntityManager();


        test_aeh_students query_result = (test_aeh_students) m.createQuery("SELECT c FROM test_aeh_students c where c.name = 'Jan' ")
                .getSingleResult();
        System.out.println ("List of all customers: "+ query_result);
    }*/

    //TODO wyświetlanie porządne wyniku - teraz bez ładnych odstępów
    //TODO Integration Test
    public void getStudentVariable (){

        EntityManager m = em.createEntityManager();


        String searchedname = newname;
        TypedQuery<test_aeh_students> query = m.createQuery(
                "SELECT e FROM test_aeh_students e WHERE e.name = :searchedname" , test_aeh_students.class);
        test_aeh_students student = query.setParameter("searchedname", searchedname).getSingleResult();
        //System.out.println("Student" + student);

            if (student.getName().equals(searchedname)){
                System.out.println("Student id = "+student.getId());
                System.out.println("Student Name = "+student.getName());
                System.out.println("Student Surname = "+student.getSurname());
            }

    }

}




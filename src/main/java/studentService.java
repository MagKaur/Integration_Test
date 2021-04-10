import org.hibernate.service.Service;

import javax.persistence.*;

public class studentService implements Service {

    private String name;
    private String surname;
    test_aeh_students student;

    @PersistenceUnit
    EntityManagerFactory em = Persistence.createEntityManagerFactory("Integration_Test");

    studentService(test_aeh_students student)
    {
        this.student = student;
    }

    public void assignData (String data)
    {
        splitData(data);
        //student.setId();
        this.student.setName(name);
        this.student.setSurname(surname);
    }

    public boolean addStudent()
    {
        boolean temp;
        try{
            EntityManager entityManager = em.createEntityManager();
            entityManager.getTransaction().begin();
            entityManager.merge(student);
            entityManager.getTransaction().commit();
            entityManager.close();
        }
        catch(Exception e)
        {
            System.out.println("Data insert failed.. " + e);
            temp = false;
        }
        finally {
            temp = true;
        }
        return temp;
    }

    public test_aeh_students getStudent()
    {
        EntityManager entityManager = em.createEntityManager();
        TypedQuery<test_aeh_students> query = entityManager.createQuery(
                "SELECT e FROM test_aeh_students e WHERE e.name = :name AND e.surname = :surname" , test_aeh_students.class);
        this.student = query.setParameter("name", name).setParameter("surname", surname).getSingleResult();
        displayStudent();
        return student ;
    }

    private void splitData(String data)
    {
        this.name = data.split(" ")[0];
        this.surname = data.split(" ")[1];
    }

    public void displayStudent()
    {
        System.out.println("Student id = "+student.getId());
        System.out.println("Student Name = "+student.getName());
        System.out.println("Student Surname = "+student.getSurname());
    }

}

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

    public void przypiszDane(String data)
    {
        splitData(data);
        //student.setId();
        this.student.setName(name);
        this.student.setSurname(surname);
    }

    public void addStudent()
    {
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void getStudent()
    {
        EntityManager entityManager = em.createEntityManager();
        TypedQuery<test_aeh_students> query = entityManager.createQuery(
                "SELECT e FROM test_aeh_students e WHERE e.name = :name" , test_aeh_students.class);
        this.student = query.setParameter("name", name).getSingleResult();
        wyswietlStudenta();
    }

    private void splitData(String data)
    {
        this.name = data.split(" ")[0];
        this.surname = data.split(" ")[1];
    }

    public void wyswietlStudenta()
    {
        System.out.println("Student id = "+student.getId());
        System.out.println("Student Name = "+student.getName());
        System.out.println("Student Surname = "+student.getSurname());
    }

}

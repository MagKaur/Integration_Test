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
        student = student;
    }

    public void addStudent(String data)
    {
        splitData(data);
        student.setId();
        student.setName(name);
        student.setSurname(surname);
        EntityManager entityManager = em.createEntityManager();
        entityManager.getTransaction().begin();
        entityManager.merge(student);
        entityManager.getTransaction().commit();
        entityManager.close();
    }

    public void getStudent(String data)
    {
        splitData(data);
        EntityManager entityManager = em.createEntityManager();
        TypedQuery<test_aeh_students> query = entityManager.createQuery(
                "SELECT e FROM test_aeh_students e WHERE e.name = :name" , test_aeh_students.class);
        student = query.setParameter("name", name).getSingleResult();
        wyswietlStudenta();
    }

    private void splitData(String data)
    {
        name = data.split(" ")[0];
        surname = data.split(" ")[1];
    }

    public void wyswietlStudenta()
    {
        System.out.println("Student id = "+student.getId());
        System.out.println("Student Name = "+student.getName());
        System.out.println("Student Surname = "+student.getSurname());
    }

}

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table (name = "TEST_AEH_STUDENTS")
public class test_aeh_students {

    @Id
    @Column (name = "test_student_id")
    @GeneratedValue(generator = "incrementor")
    @GenericGenerator(name = "incrementator", strategy = "increment")
    private int id;

    @Column (name = "name")
    private String name;

    @Column (name = "surname")
    private String surname;


    public test_aeh_students() {}


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}

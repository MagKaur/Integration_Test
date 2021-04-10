import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;


@Entity
@Table (name = "TEST_AEH_STUDENTS")
public class test_aeh_students {

    @Id
    @Column (name = "TEST_STUDENT_ID")
    @GeneratedValue(generator = "ISEQ$$_78013")
    @GenericGenerator(name = "ISEQ$$_78013", strategy = "increment")
    private int id;

    @Column (name = "NAME")
    private String name;

    @Column (name = "SURNAME")
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

    public int setId() {return id;}

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

}

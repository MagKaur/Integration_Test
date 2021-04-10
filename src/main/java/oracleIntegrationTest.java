import org.junit.*;
import java.lang.reflect.*;

public class oracleIntegrationTest {

    test_aeh_students student = new test_aeh_students();
    studentService service = new studentService(student);

    @Test
    public void ifDataAdded()
    {
        String data = "Barbara Mrówka";
        service.przypiszDane(data);
        //Adding student to database
        Assert.assertTrue(service.addStudent());
    }

    @Test
    public void ifDataPulled()
    {
        String data = "Barbara Mrówka";
        service.przypiszDane(data);
        Assert.assertEquals(this.student.getName() + " " + this.student.getSurname() ,
                service.getStudent().getName() + " " + service.getStudent().getSurname());
    }

}

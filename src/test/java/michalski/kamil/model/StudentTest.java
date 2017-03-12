package michalski.kamil.model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;

import java.util.LinkedList;
import java.util.List;

@RunWith(JUnit4.class)
public class StudentTest {

    private Student s;

    private List<Student> studentList = new LinkedList<Student>();

    @Before
    public void setUp() throws Exception {
        s = new Student("John", "Doe", 1);
    }

    @After
    public void tearDown() throws Exception {

    }

    @Test
    public void shouldReturnProprStudentName() throws Exception {
        Assert.assertEquals("John", s.getName());
    }


    @Test
    public void shouldReturnProprStudentSurname() throws Exception {
        Assert.assertNotNull(s.getSurname());
    }

    @Test
    public void shouldReturnTwoStudents() {
        studentList.add(s);
        studentList.add(s);
        studentList.add(s);

        Assert.assertEquals(3, studentList.size());
    }


}
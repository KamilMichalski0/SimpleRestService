package michalski.kamil.service;

import michalski.kamil.model.Student;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@SpringBootTest
public class StudentServiceTest {
    @Autowired
    private StudentService studentService;

    @Before
    public void setUp() throws Exception {

    }

    @After
    public void tearDown() throws Exception {

    }


    public void shouldReturnProperStudent() throws Exception {
        Student student = studentService.getStudentById((long) 1);
        Assert.assertNotNull(student);
        Assert.assertEquals("returning proper id", (long) 1L, (long) student.getId());

    }

    @Test(expected = IllegalArgumentException.class)
    public void shouldThrowExaptionHerNotFound() throws Exception{
        Student student = studentService.getStudentById((long)99);
        Assert.assertNotNull(student);
    }




}
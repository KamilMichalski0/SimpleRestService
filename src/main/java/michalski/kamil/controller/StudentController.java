package michalski.kamil.controller;

import michalski.kamil.model.Student;
import michalski.kamil.service.StudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RequestMapping("/students")
@RestController
public class StudentController {
    @Autowired
    private StudentService studentService;

    @ResponseBody
    @RequestMapping(method = RequestMethod.GET)
    public Collection<Student> list() throws Exception {
        return studentService.findAll();
    }

    @ResponseBody
    @RequestMapping("/{id}")
    public Student getStudentById(@PathVariable("id") Long id) throws Exception {
        return studentService.getStudentById(id);
    }

    @RequestMapping(method = RequestMethod.POST)
    public
    @ResponseBody
    String addSudent(@RequestBody Student student) {
        studentService.addStudent(student);
        return student.getName();
    }

    @DeleteMapping("/{id}")
    public void deleteStudent(@PathVariable Long id) {
        studentService.deleteStudent(id);
    }

    @PutMapping
    public
    @ResponseBody
    Boolean updateStudent(@RequestBody Student student) {
        return studentService.updateStudent(student);
    }
}

package michalski.kamil.service;


import michalski.kamil.dao.StudentRepository;
import michalski.kamil.model.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class StudentService {
    @Autowired
    private StudentRepository studentRepository;

    public Collection<Student> findAll() {
        return studentRepository.getAllStudents();
    }


    public Student getStudentById(Long id) {

        if (id > studentRepository.getAllStudents().size()) {
            throw new IllegalArgumentException("Nie ma takiego studenta");
        }
        return studentRepository.getStudentById(id);
    }

    public void addStudent(Student student) {
        studentRepository.addStudent(student);
    }

    public void deleteStudent(Long id) {
        if (id > studentRepository.getAllStudents().size()) {
            throw new IllegalArgumentException("Nie ma takiego studenta w bazie");
        } else {
            studentRepository.deleteStudentById(id);
        }
    }

    public Boolean updateStudent(Student student) {
        Student student1 = studentRepository.updateById(student);
        if (student1 != null)
            return true;
        else
            return false;
    }


}

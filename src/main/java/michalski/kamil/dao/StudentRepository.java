package michalski.kamil.dao;


import michalski.kamil.model.Student;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
@Repository
public class StudentRepository {
    HashMap<Long,Student> studentHashMap;

    public StudentRepository(){
        studentHashMap = new HashMap<>();
        studentHashMap.put(1L,new Student("Jarek","Krawczyk",1));
        studentHashMap.put(2L,new Student("Zenek","Krawczyk",2));
        studentHashMap.put(3L,new Student("Zenek","Krawczyk",3));
    }

    public Collection<Student> getAllStudents(){
        return studentHashMap.values();
    }

    public Student getStudentById(Long id){
        return studentHashMap.get(id);
    }

    public void deleteStudentById(Long id){
        studentHashMap.remove(id);
    }

    public void addStudent(Student student){
        studentHashMap.put(student.getId(),student);
    }

    public Student updateById(Student student){
        studentHashMap.replace(student.getId(),student);

        return student;
    }






}

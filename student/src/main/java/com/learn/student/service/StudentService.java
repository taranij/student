package com.learn.student.service;
 
import java.util.List;
 
import org.springframework.stereotype.Service;
 
import com.learn.student.entity.Student;
import com.learn.student.repository.StudentRepository;
 
@Service
public class StudentService {
 
   private final StudentRepository studentRepository;
 
   public StudentService(StudentRepository studentRepository) {
       this.studentRepository = studentRepository;
   }
public Student updateStudent(int id, Student updatedStudent) {
       return studentRepository.findById(id)
               .map(student -> {
                   student.setStudentName(updatedStudent.getStudentName());                    
                   return studentRepository.save(student);
               })
               .orElse(null);
   }
   public Student saveStudent(Student student) {
       return studentRepository.save(student);
   }
 
   public List<Student> getAllStudents() {
       return studentRepository.findAll();
   }
 
   public Student getStudentById(int id) {
       return studentRepository.findById(id).orElse(null);
   }
 
   public void deleteStudent(int id) {
       studentRepository.deleteById(id);
   }
}
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocio;

import dominio.Student;
import infraestructura.IStudentRepository;
//import infraestructura.StudentRepository;
import java.util.List;

public class StudentService {
    
    private final IStudentRepository repository;
    
    // Inyección de dependencias
    public StudentService(IStudentRepository repository) {
        this.repository = repository;
    }
    
    public String registerStudent(Student student) {
        if (student.getName().isEmpty()) return "ERROR: El nombre es obligatorio";
        repository.save(student);
        return "El estudiante ha sido agregado a la Base de Datos";
    }

    public List<Student> getAllStudents() {
        return repository.findAll();
    }
    
    /*private StudentRepository repository 
            = new StudentRepository();
    
    public String registerStudent(Student student){
        if(student.getName().isEmpty())
            return "ERROR: El nombre es obligatorio";
        
        repository.save(student);
        return "El estudiante ha sido "
                + "agregado exitosamente";
    }
    
    public List<Student> getAllStudents(){
        return repository.findAll();
    }
    
    public String removeStudent(String code){
        if(code.isBlank())
            return "ERROR: No es un código válido";
        
        repository.delete(code);
        return "El estudiante fue removido exitosamente";
    }
    
    public String updateStudent(Student student){
        if(student.getCode().isEmpty())
            return "ERROR: El código es obligatorio";
        
        repository.update(student);
        return "El estudiante ha sido "
                + "modificado exitosamente";
    }*/    
}

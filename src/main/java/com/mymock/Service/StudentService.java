package com.mymock.Service;

import com.mymock.dao.IStudentDAO;
import com.mymock.domain.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by rkavya on 3/23/2015.
 */
@Service
public class StudentService implements IStudentService {

    @Autowired
    private IStudentDAO iStudentDAO;


    @Transactional
    public void insert(Student student) {
        iStudentDAO.insert(student);
    }

    @Transactional
    public void editStudent(Student student) {
        iStudentDAO.editStudent(student);
    }


    @Transactional
    public void deleteStudent(int studentId){iStudentDAO.deleteStudent(studentId);}


    @Transactional
    public Student getStudent(int studentId){return iStudentDAO.getStudent(studentId);}


    @Transactional
    public List<Student> getAllStudents(){return iStudentDAO.getAllStudents();}
}

package com.mymock.dao;

import com.mymock.domain.Student;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by rkavya on 3/23/2015.
 */
@Repository
public class StudentDAO implements IStudentDAO {

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(Student student) {
        sessionFactory.getCurrentSession().save(student);
    }

    @Override
    public void deleteStudent(int studentId) {
        sessionFactory.getCurrentSession().delete(getStudent(studentId));
    }

    @Override
    public Student getStudent(int studentId) {
        return (Student)sessionFactory.getCurrentSession().get(Student.class,studentId);
    }

    @Override
    public List<Student> getAllStudents() {

      return sessionFactory.getCurrentSession().createQuery("from Student").list();
    }

    @Override
    public void editStudent(Student student){
        sessionFactory.getCurrentSession().update(student);
    }

}

package com.mymock.dao;
import java.util.*;

import com.mymock.domain.Student;

/**
 * Created by rkavya on 3/23/2015.
 */
public interface IStudentDAO {

    void insert(Student student);

    void deleteStudent(int studentId);

    void editStudent(Student student);

    Student getStudent(int studentId);

    List<Student> getAllStudents();

}

package com.demo.dao;

import com.demo.entity.Student;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
@Qualifier("fakeData")
public class FakeStudentDao implements StudentDao {
    private static Map<Integer, Student> students;

    static {
        students = new HashMap<Integer, Student>() {
            {
                put(1, new Student(1, "Said", "Computer Science"));
                put(2, new Student(2, "Alex U", "Finance"));
                put(3, new Student(3, "Anna", "Maths"));
            }
        };
    }

    @Override
    public Collection<Student> getAllStudents(){
        return FakeStudentDao.students.values();
    }

    @Override
    public Student getStudentById(int id){
        return FakeStudentDao.students.get(id);
    }

    @Override
    public void removeStudentById(int id) {
        FakeStudentDao.students.remove(id);
    }

    @Override
    public void updateStudent(Student student){
        Student s = students.get(student.getId());

        s.setCourse(student.getCourse());
        s.setName(student.getName());
        students.put(student.getId(), student);
    }

    @Override
    public void insertStudent(Student student) {
        FakeStudentDao.students.put(student.getId(), student);
    }
}

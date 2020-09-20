package com.itheima.edu.service;

import com.itheima.edu.dao.StudentDao;
import com.itheima.edu.domain.Student;

public class StudentService {
    private StudentDao studentDao = new StudentDao();

    public boolean addStudent(Student stu) {
        return studentDao.addStudent(stu);
    }

    public boolean isExist(String id) {
        Student[] stus = studentDao.findAllStudent();
        boolean exist = false;
        for (int i = 0; i < stus.length; i++) {
            if(stus[i] != null && stus[i].getId().equals(id)){
                exist = true;
                break;
            }
        }
        return exist;
    }

    public void deleteStudentById(String id) {
        studentDao.deleteStudentById(id);
    }

    public Student[] queryStudent() {
        Student[] stus = studentDao.findAllStudent();
        boolean flag = false;
        for (int i = 0; i < stus.length; i++) {
            if(stus[i] != null){
                flag = true;
            }
        }
        if(flag){
            return stus;
        }else{
            return null;
        }
    }

    public void updateStudentById(String id, Student stu) {
        studentDao.updateStudentById(id, stu);
    }
}

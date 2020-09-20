package com.itheima.edu.dao;

import com.itheima.edu.domain.Student;

public class StudentDao {
    private static Student[] stuArr = new Student[5];

    public boolean addStudent(Student stu){
        int index = -1;
        for (int i = 0; i < stuArr.length; i++) {
            if(stuArr[i] == null){
                index = i;
                break;
            }
        }

        if(index != -1){
            stuArr[index] = stu;
            return true;
        }else{
            return false;
        }
    }

    public Student[] findAllStudent() {
        return stuArr;
    }

    public void deleteStudentById(String id) {
        int index = getIndex(id);
        stuArr[index] = null;
    }

    public int getIndex(String id){
        int index = -1;
        for (int i = 0; i < stuArr.length; i++) {
            if(stuArr[i] != null && stuArr[i].getId().equals(id)){
                index = i;
            }
        }
        return index;
    }

    public void updateStudentById(String id, Student stu) {
        int index = getIndex(id);
        stuArr[index] = stu;
    }
}
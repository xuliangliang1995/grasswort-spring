package com.grasswort.beans.definition.model;

import java.util.List;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/1
 */
public class Teacher extends User {
    /**
     * 学生列表
     */
    private List<Student> students;

    public List<Student> getStudents() {
        return students;
    }

    public void setStudents(List<Student> students) {
        this.students = students;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "students=" + students +
                "} " + super.toString();
    }
}

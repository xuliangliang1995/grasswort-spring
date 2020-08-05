package com.grasswort.beans.definition.model;

/**
 * @author xuliangliang
 * @Description
 * @Date 2020/8/1
 */
@TestAnnotation("student")
public class Student extends User implements IStudy {

    public Student() {
    }

    public Student(String name, Integer age, IDCard idCard) {
        super(name, age);
        this.idCard = idCard;
    }

    /**
     * 学号
     */
    private Teacher teacher;
    /**
     * 身份证号
     */
    private IDCard idCard;

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public IDCard getIdCard() {
        return idCard;
    }

    public void setIdCard(IDCard idCard) {
        this.idCard = idCard;
    }

    @Override
    public String toString() {
        return "Student{" +
                "teacher=" + teacher +
                ", idCard=" + idCard +
                "} " + super.toString();
    }

    /**
     * 学习
     */
    @Override
    public void study() {
        System.out.println(getName() + ": 我要开始学习啦 ~");
    }
}

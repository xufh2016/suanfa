package com.example.suanfademo.webflux.bean;

import lombok.Data;

import java.util.Objects;

/**
 * @className: Student
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/8/12
 */
@Data
public class Student {
    private Long id;
    private String name;
    private int age;
    private String address;
    public Student() {}
    public Student(Long id, String name, int age, String address) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
    }
    @Override
    public String toString() {
        return "Student{" + "id=" + id + ", name='" + name + '\'' +
                ", age=" + age + ", address='" + address + '\'' + '}';
    }
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Student student = (Student) o;
        return age == student.age &&
                Objects.equals(id, student.id) &&
                Objects.equals(name, student.name) &&
                Objects.equals(address, student.address);
    }
    @Override
    public int hashCode() {
        return Objects.hash(id, name, age, address);
    }
}

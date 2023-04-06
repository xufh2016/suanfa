package com.example.suanfademo.webflux;

import com.example.suanfademo.webflux.bean.Student;

import java.util.ArrayList;
import java.util.List;
import java.util.LongSummaryStatistics;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * @className: StreamDemo
 * @description: TODO 类描述
 * @author: xufh
 * @date: 2022/8/11
 */
public class StreamDemo {
    public static void main(String[] args) {
        Student s1 = new Student(1L, "肖战", 15, "浙江");
        Student s2 = new Student(2L, "王一博", 15, "湖北");
        Student s3 = new Student(3L, "杨紫", 17, "北京");
        Student s4 = new Student(4L, "李现", 17, "浙江");
        List<Student> students = new ArrayList<>();
        students.add(s1);
        students.add(s2);
        students.add(s3);
        students.add(s4);

        LongSummaryStatistics summaryStatistics = students.stream().collect(Collectors.summarizingLong(Student::getAge));
        System.out.println("summaryStatistics = " + summaryStatistics);
        Map<Boolean, List<Student>> collect = students.stream().collect(Collectors.partitioningBy(student -> student.getAddress().equals("北京")));
        System.out.println("collect = " + collect);

        /**
         * peek操作也是映射，和map类似，但是peek依然是会映射成原来的集合，只是修改了其中的部分属性
         */
        List<Student> collect1 = students.stream().peek(student -> {
            student.setAge(student.getAge()+2);
        }).collect(Collectors.toList());
        System.out.println("collect1 = " + collect1);
    }
}

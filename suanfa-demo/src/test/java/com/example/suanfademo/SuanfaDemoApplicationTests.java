package com.example.suanfademo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.stream.Collectors;

@SpringBootTest
class SuanfaDemoApplicationTests {

    @Test
    void contextLoads() {
    }

    @Test
    public void testOper() {
        System.out.println((int) Math.pow(10, 0));
    }

    @Test
    public void testStream() {
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 8);
      /*  //去掉首部的三个数据
        list.stream().skip(3).forEach(System.out::println);*/
       /* //表示从t参数开始求和，下面的代码就表示从0开始，求和list中的值，如果入参的t变为2，那么就是从2开始
        Integer reduce = list.stream().reduce(0, Integer::sum);
        System.out.println("reduce = " + reduce);*/
        //peek中执行的代码仅仅可以用于调试，不会对原数组产生变化，也不会对新生成的数据产生变化，比如下面的collect中的值依然是上面的list中的值
        List<Integer> collect = list.stream().peek(item -> System.out.println(item + " * 2 = " + item * 2)).collect(Collectors.toList());
        collect.forEach(item -> System.out.println("item = " + item));
        System.out.println(list==collect);
    }

    @Test
    public void testHash(){
        Integer n = 10434;
        Integer y = 42123;
        String str = "10434";
        String str1 = "10443";
        String aa = "hello world";
        System.out.println(n.hashCode());
        System.out.println(y.hashCode());
        System.out.println(str.hashCode());
        System.out.println("str1.hashCode() = " + str1.hashCode());
        System.out.println("aa.hashCode() = " + aa.hashCode());
        HashMap<Object, Object> map = new HashMap<>();
        Object put = map.put("1", 2);
        System.out.println("put = " + put);
        //hashmap的put方法返回值是上一次存的value，初次赋值时，返回的是null
        Object put1 = map.put("1", 5);
        System.out.println("put1 = " + put1);
    }

}

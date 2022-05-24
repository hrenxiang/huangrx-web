package com.dao;

import com.bean.student;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import jdk.nashorn.internal.parser.TokenType;
import org.junit.Test;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Charon
 * @date 2020/7/21
 **/
public class json {

    @Test
    public void javaBeanToJson() {

        student student = new student("hh", 31);

        Gson gson = new Gson();

        //由javaBean对象转换为 json对象
        String s = gson.toJson(student);

        System.out.println(s);

        //由json对象转换为 javaBean对象
        com.bean.student student1 = gson.fromJson(s, student.getClass());
        System.out.println(student1);
        System.out.println(student.getClass());

    }

    @Test
    public void test2() {

        List<student> list = new ArrayList<student>();

        list.add(new student("hh", 21));
        list.add(new student("ff", 22));

        Gson gson = new Gson();

        String s = gson.toJson(list);

        System.out.println(s);

        List<student> ss = gson.fromJson(s, new TypeToken<ArrayList<student>>() {
        }.getType());

        student s1 = ss.get(0);

        System.out.println(s1);
    }

    @Test
    public void test3() {

        Map<Integer, student> map = new HashMap<>();

        map.put(1, new student("hh", 21));
        map.put(2, new student("gg", 22));

        System.out.println(map);

        Gson gson = new Gson();

        String s = gson.toJson(map);

        System.out.println(s);

        Map<Integer, student> map1 = gson.fromJson(s, new TypeToken<HashMap<Integer, student>>() {
        }.getType());

        System.out.println(map1.get(1));

        Type type = new TypeToken<HashMap<Integer, student>>() {
        }.getType();

        System.out.println(type);
    }
}

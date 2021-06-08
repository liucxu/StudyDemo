package com.company;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

public class ReflectDemo {
    public static void main(String[] args){
        Class sClass=String.class;
        try {
            Constructor constructor=sClass.getConstructor(String.class);
            Object ss=constructor.newInstance("123");
            System.out.println(ss);
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }


        Class reflectClass=ReflectClass.class;
        try {
            Object reflectRef=reflectClass.newInstance();
            Method[] methods=reflectClass.getDeclaredMethods();
            for (Method method:methods)
                System.out.println(method);
            Method method=reflectClass.getMethod("add");
            method.invoke(reflectRef);
        } catch (InstantiationException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

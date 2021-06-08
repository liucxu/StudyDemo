package com.company;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

public class TypeEraser {
    public static void main(String[] args){
        List<String> list1=new ArrayList<>();
        List<Father> list2=new ArrayList<Father>();
        list2.add(new Father(1,2,3));
        System.out.println(list1.getClass()==list2.getClass());

        try {
            Method method=list2.getClass().getMethod("add", Object.class);
            method.invoke(list2,"abc");
            for(int index=0;index<list2.size();index++){
                System.out.println(list2.get(index).returnString());
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

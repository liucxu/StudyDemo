package com.company;

import java.util.ArrayList;
import java.util.List;

public class GenericDemo {
    public static void main(String[] args){
        List<String> list=new ArrayList<String>();
        list.add("first");
        list.add("second");
        for (int index=0;index<list.size();index++){
            System.out.println((String) list.get(index));
        }
        List<String> list1=new ArrayList<String>();
        List<Integer> list2=new ArrayList<>();
        Class class1=list1.getClass();
        Class class2=list2.getClass();
        if(class1.getName().equals(class2.getName()))
            System.out.println("类型相同");
        Generic<Integer> generic=new Generic<>(100);
        System.out.println(generic.getKey()+"");
    }
}

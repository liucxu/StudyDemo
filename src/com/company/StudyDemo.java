package com.company;

public class StudyDemo {
    static{
        System.out.println("123");
    }
    public static void main(String[] args){
        String str1=new String("aaa");
        String str2=new String("aaa");
        System.out.println(str1==str2);


        String str3=str1.intern();
        String str4=str2.intern();
        System.out.println(str3==str4);


        String str5="abc";
        String str6="abc";
        System.out.println(str5==str6);

        String str7=new String("test");
        str7.intern();
        String str8="test";
        System.out.println(str7==str8);

        StudyDemo demo1=new StudyDemo();
        StudyDemo demo2=new StudyDemo();
    }
}

package com.company;

@MyAnnotation
public class MyAnnotationDemo {
    public static void main(String[] args){
        System.out.println(AnnotationSon.class.getAnnotation(MyAnnotation.class));
    }
}

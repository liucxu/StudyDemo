package com.company;

public class AnnotationMain {
    public static void main(String[] args){
        Class annotationFather=AnnotationFather.class;
        boolean isAnnotation=annotationFather.isAnnotationPresent(MyAnnotation.class);
        if(isAnnotation){
            MyAnnotation annotation= (MyAnnotation) annotationFather.getAnnotation(MyAnnotation.class);
            System.out.println(annotation.name());
        }
    }
}

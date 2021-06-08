package com.company;

import java.lang.reflect.Field;
import java.util.Arrays;

public class JavaDemo {
    public static void main(String [] args){
        Integer integer1=Integer.valueOf(100);
        Integer integer2=Integer.valueOf(100);
        System.out.println(integer1==integer2);

        Integer integer3=new Integer(123);
        Integer integer4=new Integer(123);
        System.out.println(integer3==integer4);

        final int[] values={1,2,3};
        int[] values2={4,5,6};
        values[1]=100;
        System.out.println(Arrays.stream(values).toArray());

        String str="Lili";
        try {
            Field field=String.class.getDeclaredField("value");
            field.setAccessible(true);
            byte[] re=(byte[])field.get(str);
            re[0]=78;
            System.out.println(str);
            System.out.println();
        } catch (NoSuchFieldException e) {
            e.printStackTrace();
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        }
    }
}

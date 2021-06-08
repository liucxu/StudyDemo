package com.company;

public class StringDemo {
    public static void main(String[] args){
        String str1=new String("str")+new String("01");
        String str2="str01";
        str1.intern();
        System.out.println(str2==str1);

        String str3=new String("1");
        str3.intern();
        String str4="1";
        System.out.println(str3==str4);

        String switch_s="a";
        switch (switch_s){
            case "a":
                System.out.println("a");
                break;
        }
    }
}

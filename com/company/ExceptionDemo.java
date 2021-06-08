package com.company;

import jdk.internal.org.objectweb.asm.tree.TryCatchBlockNode;

import java.io.IOException;

public class ExceptionDemo {
    public static void main(String[] args){
        try {
            String test=null;
            System.out.println(test.toString());
            InterfaceImpl interfaceC=new InterfaceImpl();
            interfaceC.print();
        }catch (NullPointerException e){
            System.out.println(e.toString());
        }
    }
    private void print() {

    }
}

package com.company;

import java.util.HashSet;

public class Father {
    private int x;
    private int y;
    private int z;

    public Father(int x,int y,int z){
        this.x=x;
        this.y=y;
        this.z=z;
    }

    @Override
    public boolean equals(Object o) {
        if(o==this)
            return true;
        if(o==null||o.getClass()!=this.getClass())
            return false;
        Father father=(Father) o;
        if(father.x!=this.x)
            return false;
        if(father.y!=this.y)
            return false;
        if(father.z!=this.z)
            return false;
        return true;
    }

    @Override
    public int hashCode() {
        return this.x*10+this.y*5+this.z*2;
    }

    public static void main(String[] args){
        Father father1=new Father(1,2,3);
        Father father2=new Father(1,2,3);
        System.out.println(father1.equals(father2));

        HashSet<Father> set = new HashSet<>();
        set.add(father1);
        set.add(father2);
        System.out.println(set.size());

        
    }
}

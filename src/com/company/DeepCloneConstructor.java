package com.company;

public class DeepCloneConstructor {
    public int[] arr;
    public DeepCloneConstructor(){
        arr=new int[10];
        for(int index=0;index<10;index++){
            arr[index]=index;
        }
    }
    public DeepCloneConstructor(DeepCloneConstructor origin){
        arr=new int[origin.arr.length];
        for (int index=0;index<origin.arr.length;index++){
            arr[index]=origin.arr[index];
        }
    }

    public void setArr(int index,int val){
        arr[index]=val;
    }

    public int getVal(int index){
        return arr[index];
    }

    public static void main(String[] args){
        DeepCloneConstructor deep1=new DeepCloneConstructor();
        DeepCloneConstructor deep2=new DeepCloneConstructor(deep1);
        deep1.setArr(2,222);
        System.out.println(deep1.getVal(2)+", "+deep2.getVal(2));
    }

}

package com.company;

import java.lang.reflect.Method;

public class BankTransferMain {
    @BankTransferMoney(max = 15000)
    public static void transferMoney(double money){
        System.out.println(processTransferBankMoney(money));
    }
    public static String processTransferBankMoney(double toTransferMoney){
        try {
            Method method=BankTransferMain.class.getMethod("transferMoney",double.class);
            boolean isAnnotation=method.isAnnotationPresent(BankTransferMoney.class);
            if(isAnnotation){
                BankTransferMoney bankTransferMoney=method.getAnnotation(BankTransferMoney.class);
                double max=bankTransferMoney.max();
                if(toTransferMoney<=max){
                    return "转账成功";
                }
                else{
                    return "转账失败";
                }
            }
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
        return "";
    }
    public static void main(String[] args){
        transferMoney(10000);
        transferMoney(20000);
    }
}

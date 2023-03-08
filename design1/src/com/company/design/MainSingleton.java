package com.company.design;

import com.company.design.singleton.AClazz;
import com.company.design.singleton.BClazz;
import com.company.design.singleton.SocketClient;

public class MainSingleton {
    public static void main(String[] args) {
        AClazz aclazz = new AClazz();
        BClazz bclazz = new BClazz();

        SocketClient aClient = aclazz.getSocketClient();
        SocketClient bClient = bclazz.getSocketClient();

        System.out.println("두개의 객체가 동일한지 확인");
        System.out.println(aclazz.equals(bclazz));



    }



}
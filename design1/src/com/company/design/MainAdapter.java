package com.company.design;

import com.company.design.adapter.*;

public class MainAdapter {
    public static void main(String[] args) {
        //110v
        HairDryer hairDryer = new HairDryer();
        connect(hairDryer);
        //220v
        Cleaner cleaner = new Cleaner();
        //어뎁터를 통해 연결
        Electronic110V adapter = new SocketAdapter(cleaner);
        connect(adapter);

        AirConditioner airConditioner = new AirConditioner();
        Electronic110V airAdapter = new SocketAdapter(airConditioner);
        connect(airAdapter);
    }

    //콘텐츠
    public static void connect(Electronic110V electronic110V) {
        electronic110V.powerOn();
    }
}


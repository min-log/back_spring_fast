package com.company.design;

import com.company.design.observer.Button;
import com.company.design.observer.IButtonListener;

public class MainObserver {
    public static void main(String[] args) {
        Button button = new Button("버튼");
        button.addListener(new IButtonListener() {
            @Override
            public void clickEvent(String event) {
                System.out.println(event);
            }
        });
        button.click("메시지 전달 : click1");
        button.click("메시지 전달 : click2");
        button.click("메시지 전달 : click3");
        button.click("메시지 전달 : click4");

    }
}

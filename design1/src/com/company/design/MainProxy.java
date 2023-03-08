package com.company.design;

import com.company.design.aop.AppBrowser;
import com.company.design.proxy.Browser;
import com.company.design.proxy.BrowserProxy;
import com.company.design.proxy.IBrowser;

import java.util.concurrent.atomic.AtomicLong;

public class MainProxy {
    public static void main(String[] args){
        /*
        Browser browser = new Browser("www.naver.com");
        browser.show();
        browser.show();
        browser.show();
        */
        /*
        BrowserProxy browserProxy = new BrowserProxy("www.naver.com");
        browserProxy.show();
        browserProxy.show();
        browserProxy.show();

         */

        AtomicLong start = new AtomicLong();
        AtomicLong end = new AtomicLong();
        IBrowser aopBrowser = new AppBrowser("www.naver.com",
            ()->{
                System.out.println("before");
                start.set(System.currentTimeMillis());
            },
            ()->{
                long now = System.currentTimeMillis();
                end.set(now - start.get());
            }
        );

        aopBrowser.show();
        System.out.println("loding time : " + end.get());


        aopBrowser.show();
        System.out.println("loding time : " + end.get());

    }
}

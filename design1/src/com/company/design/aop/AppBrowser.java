package com.company.design.aop;

import com.company.design.proxy.Html;
import com.company.design.proxy.IBrowser;

public class AppBrowser implements IBrowser {
    private String url;
    private Html html;
    //aop는 관점지향으로 앞과 뒤를 체크
    private Runnable before;
    private Runnable after;

    public AppBrowser(String url, Runnable before, Runnable after) {
        this.url = url;
        this.before = before;
        this.after = after;
    }

    @Override
    public Html show() {
        before.run();
        if (html == null){
            this.html = new Html(url);
            System.out.println("AopBrowser html loading from : " + url );
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        after.run();
        System.out.println("AopBrowser html cache : " + url );
        return html;
    }
}

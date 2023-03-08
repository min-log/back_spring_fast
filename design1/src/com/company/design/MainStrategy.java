package com.company.design;

import com.company.design.strategy.*;

public class MainStrategy {
    public static void main(String[] args) {
        //사용하기 위한 기본객체
        Encoder encoder = new Encoder();

        //전략
        //base64
        EncodingStrategy base64 = new Base64Strategy();
        //normal
        EncodingStrategy normal = new NormalStrategy();
        //append
        EncodingStrategy append = new AppendStrategy();

        String message = "hello java";

        //사용시 전략 세팅
        //base64
        encoder.setEncodingStrategy(base64);
        String base64Result = encoder.getMessage(message);
        System.out.println(base64Result);
        //normal
        encoder.setEncodingStrategy(normal);
        String normalResult = encoder.getMessage(message);
        System.out.println(normalResult);
        //append
        encoder.setEncodingStrategy(append);
        String appendResult = encoder.getMessage(message);
        System.out.println(appendResult);
    }
}

package com.company.design;

import com.company.design.facade.Ftp;
import com.company.design.facade.Reader;
import com.company.design.facade.SftpClient;
import com.company.design.facade.Writer;

public class MainFacade {
    public static void main(String[] args) {
        //클라이언트가 다 의존성을 가지고 만들고 있다.
        /*
        Ftp ftpClient = new Ftp("www.ji.co.kr",22,"/home/etc");
        ftpClient.connect();
        ftpClient.moveDirectory();

        Writer writer = new Writer("text.tmp");
        writer.fileConnect();
        writer.write();
        Reader reader = new Reader("text.tmp");
        reader.fileConnect();
        reader.fileRead();
        //연결종료
        reader.fileDisconnect();
        writer.fileDisconnect();
        ftpClient.disConnect();

         */

        SftpClient sftpClient = new SftpClient("www.ji.co.kr",22,"/home/etc","text.tmp");
        sftpClient.connect();
        sftpClient.writer();
        sftpClient.read();
        sftpClient.disConnect();
    }
}

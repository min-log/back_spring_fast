package com.company.design.facade;

public class SftpClient {
    //모든 의존성을 가지고 있도록
    private Ftp ftp;
    private Reader reader;
    private Writer writer;

    //생성자
    public SftpClient(Ftp ftp, Reader reader, Writer writer) {
        this.ftp = ftp;
        this.reader = reader;
        this.writer = writer;
    }
    public SftpClient(String host,int port, String path, String fileName) {
        this.ftp = new Ftp(host, port, path);
        this.reader = new Reader(fileName);
        this.writer = new Writer(fileName);
    }


    // 연결될때 실행될 내용들
    public void connect() {
        ftp.connect();
        ftp.moveDirectory();
        writer.fileConnect();
        reader.fileConnect();

    }
    public void disConnect(){
        reader.fileDisconnect();
        writer.fileDisconnect();
        ftp.disConnect();
    }

    //읽고 쓰는 기능 추가
    public void read(){
        reader.fileRead();
    }

    public void writer(){
        writer.write();
    }


}

public class Main {
    public static void main(String[] args) {
        //인코딩 할일이 생긴다
        String url = "www.naver.com/books/it?page=10&size=20&name=spring-boot";
        //base 64
        Encoder encoder = new Encoder();
        String result =  encoder.encoder(url);

        //url encoding
        System.out.println(result);

    }
}
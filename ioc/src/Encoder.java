import java.util.Base64;

public class Encoder {
    public String encoder(String message){
        return Base64.getEncoder().encodeToString(message.getBytes());
    }
}

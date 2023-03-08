import com.fasterxml.jackson.databind.ObjectMapper;
import dto.Car;
import dto.User;

import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String args[]){
        System.out.println("main");
        ObjectMapper objectMapper = new ObjectMapper();

        User user = new User();
        user.setName("홍길동");
        user.setAge(10);


        Car car1 = new Car();
        car1.setName("k5");
        car1.setCarName("11가 22222");
        car1.setType("sedan");

        Car car2 = new Car();
        car2.setName("Q5");
        car2.setCarName("11가 22222");
        car2.setType("suv");

        List<Car> carList = Arrays.asList(car1,car2);
        user.setCars(carList);


        System.out.println(user);




    }

}

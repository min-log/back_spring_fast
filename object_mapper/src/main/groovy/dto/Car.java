package dto;

public class Car {
    private String name;
    private String carName;
    private String type;

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", carName='" + carName + '\'' +
                ", type='" + type + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCarName(String carName) {
        this.carName = carName;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public String getCarName() {
        return carName;
    }

    public String getType() {
        return type;
    }
}

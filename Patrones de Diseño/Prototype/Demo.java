package Prototype;

public class Demo {
    public static void main(String[] args) {
        ElectricCar electricCar = new ElectricCar();
        electricCar.batteryType = "Ión-Litio";
        electricCar.color = "Black";
        electricCar.doors = 4;
        electricCar.wheels = 4;

        ElectricCar othElectricCar = (ElectricCar) electricCar.clone();

        System.out.println(electricCar.toString());
        System.out.println(othElectricCar.toString());
    }
}

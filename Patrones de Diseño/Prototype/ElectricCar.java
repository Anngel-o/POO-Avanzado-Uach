package Prototype;

public class ElectricCar extends CarPrototype{
    String batteryType;

    public ElectricCar() {
        
    }
    public ElectricCar(ElectricCar target) {
        super(target);
        if (target != null) {
            this.batteryType = target.batteryType;
        }  
    }

    @Override
    public CarPrototype clone() {
        return new ElectricCar(this);
    }
    @Override
    public String toString() {
        return "ElectricCar: " + "Color = "+this.color + ", Puertas = " + this.doors + ", Llantas = " + this.wheels + ", Bateria = " + this.batteryType;
    }
}

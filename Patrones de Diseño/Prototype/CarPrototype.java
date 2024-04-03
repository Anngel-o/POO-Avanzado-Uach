package Prototype;

public abstract class CarPrototype {
    public int wheels;
    public int doors;
    public String color;

    public CarPrototype() {
        
    }

    public CarPrototype(CarPrototype target) {
        if (target != null){
            this.wheels = target.wheels;
            this.doors = target.doors;
            this.color = target.color;
        }
    }
    public abstract CarPrototype clone();
}

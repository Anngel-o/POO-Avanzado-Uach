package Facade;

public class Main {
    public static void main(String[] args) {
        MobileFacade facade = new MobileFacade();
        Mobile mobile = facade.on();
        facade.off(mobile);
    }
}

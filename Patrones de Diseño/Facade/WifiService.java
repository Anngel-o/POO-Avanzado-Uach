package Facade;

public class WifiService implements MobileService {
    @Override
    public void start() {
        System.out.println("WIFI Service started");
    }

    @Override
    public void close() {
        System.out.println("WIFI Service started");
    }
}

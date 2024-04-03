package Facade;

import java.util.ArrayList;
import java.util.List;

public class MobileFacade {
    public Mobile on() {

        // TODO implementar la logica del programa para este metodo que generará un dipositivo Mobile utilizando las clases y metodos necesarios

        Battery battery = new Battery();
        CPU cpu = new CPU();
        GPSService gpsService = new GPSService();
        WifiService wifiService = new WifiService();

        battery.on();
        cpu.bootLoad();
        gpsService.start();
        wifiService.start();

        List<MobileService> mobileServices = new ArrayList<>();
        mobileServices.add(gpsService);
        mobileServices.add(wifiService);

        Mobile mobile = new Mobile(battery, cpu, mobileServices);

        return mobile;
    }

    public void off(Mobile mobile) {

        for (MobileService service : mobile.getMobileServices()) {
            service.close();
        }
        mobile.getCpu().shutDown();
        mobile.getBattery().off();
    }
}

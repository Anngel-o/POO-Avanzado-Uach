package Observer;

import java.util.ArrayList;
import java.util.List;
import java.rmi.Naming;
import javax.swing.JFrame;
import javax.swing.UIManager;

interface Observable {
    void addObserver(Observer observer);
    void removeObserver(Observer observer);
    void notifyObservers();
}

interface Observer {
    void update();
}

class ApplicationObservable implements Observable {
    private List<Observer> observers = new ArrayList<>();

    @Override
    public void addObserver(Observer observer) {
        observers.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        observers.remove(observer);
    }

    @Override
    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update();
        }
    }
}

class ConfigObserver implements Observer {
    private final Observable observable;

    public ConfigObserver(Observable observable) {
        this.observable = observable;
    }

    @Override
    public void update() {
        System.out.println("Configuración actualizada");
    }
}

public class Main {
    public static void main(String[] args) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());

            ApplicationObservable applicationObservable = new ApplicationObservable();

            ConfigObserver configObserver = new ConfigObserver(applicationObservable);
            applicationObservable.addObserver(configObserver);

            Config c = Config.getInstance();
            if (isLocal) {
                facadeInterface = new FacadeImplementation();
            } else {
                final String serverRMI = c.getServerRMI();
                String serviceName = "/" + c.getServiceRMI();
                int portNumber = Integer.parseInt(c.getPortRMI());
                facadeInterface = (ApplicationFacadeInterface) Naming.lookup("rmi://" + serverRMI + ":" + portNumber + serviceName");
            }

            // Notificar a los Observers después de la configuración
            applicationObservable.notifyObservers();
        } catch (Exception e) {
            e.printStackTrace();
        }

        int x = 0;
        JFrame a = new StartWindow();
        a.setVisible(true);
    }
}


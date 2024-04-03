package Decorator;

public class ClientDecoratorPattern {
    public static void main(String... args) {

        Watch basicWatch = new BasicWatch();
        basicWatch.createFunctionality();
        System.out.println("\n---------");

        Watch sportsWatch = new SportWatchDecorator(new BasicWatch());
        sportsWatch.createFunctionality();
        System.out.println("\n---------");

        Watch sportsLuxuryWatch = new LuxuryWatchDecorator(new SportWatchDecorator(new BasicWatch()));
        sportsLuxuryWatch.createFunctionality();
    }
}

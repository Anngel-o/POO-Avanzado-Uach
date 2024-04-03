package Adapter;

public class Customer {
    private int quarters;
    private int dimes;
    private int nickels;
    private int pennies;

    public Customer(int quarters, int dimes, int nickels, int pennies) {
        this.quarters = quarters;
        this.dimes = dimes;
        this.nickels = nickels;
        this.pennies = pennies;
    }

    public void deposit(Machine machine) {
        double total = machine.deposit(quarters, dimes, nickels, pennies);
        System.out.println("Valor total de las monedas depositadas: $" + total);
    }
}

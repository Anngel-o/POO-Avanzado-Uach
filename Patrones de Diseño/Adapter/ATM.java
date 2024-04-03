package Adapter;

public class ATM implements Machine{
    private double money;

    public ATM(double money) {
        this.money = money;
    }

    public double deposit(int quarters, int dimes, int nickels, int pennies) {
        double depositAmount = calculateDepositAmount(quarters, dimes, nickels, pennies);
        money += depositAmount;
        return money;
    }

    private double calculateDepositAmount(int quarters, int dimes, int nickels, int pennies) {
        return (0.25 * quarters) + (0.10 * dimes) + (0.05 * nickels) + (0.01 * pennies);
    }
}

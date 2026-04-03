public class OrderService {

    public int calculateLoyaltyPoints(double amount) {
        if (amount < 100) return 0;
        else if (amount <= 500) return (int) (amount / 10);
        else return (int) (amount / 5);
    }

    public double applyDiscount(double amount, String customerStatus) {
        if (amount < 0) throw new IllegalArgumentException("Amount cannot be negative");

        double discount = 0;
        if ("GOLD".equals(customerStatus)) discount = 0.20;
        else if ("SILVER".equals(customerStatus)) discount = 0.10;

        return amount - (amount * discount);
    }

    public double calculateShipping(int zone, double weightKg) {
        if (weightKg <= 0) return 0;
        if (weightKg > 50) throw new IllegalStateException("Overweight");

        return switch (zone) {
            case 1 -> 5.0 + (weightKg * 1.0);
            case 2 -> 10.0 + (weightKg * 2.0);
            case 3 -> 20.0 + (weightKg * 5.0);
            default -> throw new IllegalArgumentException("Unknown Zone");
        };
    }
}
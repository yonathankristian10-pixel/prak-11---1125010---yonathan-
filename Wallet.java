import java.util.List;

public class Wallet implements PaymentStrategy {
    String name;
    double cashValue;

    public Wallet(String name, double cashValue) {
        this.name = name;
        this.cashValue = cashValue;
    }

    @Override
    public boolean validate(double amount) {
        return amount > 0 && cashValue >= amount;
    }

    @Override
    public void pay(double amount) {
        cashValue -= amount;
        System.out.println("Pembayaran cash berhasil, sisa wallet: " + cashValue);
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of();
    }

    @Override
    public boolean canPay(double amount) {
        return amount >= 100 && amount <= 1000000;
    }
}
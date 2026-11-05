import java.util.List;

public class CreditCard implements PaymentStrategy {
    String cardNumber;
    double limit;
    double currentDebt;
    String ccv;
    String pin;

    public CreditCard(String cardNumber, double limit, String ccv, String pin) {
        this.cardNumber = cardNumber;
        this.limit = limit;
        this.ccv = ccv;
        this.pin = pin;
        this.currentDebt = 0;
    }

    @Override
    public boolean validate(double amount) {
        return amount > 0 && currentDebt + amount <= limit;
    }

    @Override
    public void pay(double amount) {
        currentDebt += amount;
        System.out.println("Pembayaran credit berhasil, total hutang: " + currentDebt);
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of(AuthorizationMethod.CCV, AuthorizationMethod.PIN);
    }

    @Override
    public boolean canPay(double amount) {
        return amount >= 100000 && amount <= 100000000;
    }
}
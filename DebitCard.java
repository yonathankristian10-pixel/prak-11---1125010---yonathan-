import java.util.List;

public class DebitCard implements PaymentStrategy {
    String cardNumber;
    double balance;
    String pin;

    public DebitCard(String cardNumber, double balance, String pin) {
        this.cardNumber = cardNumber;
        this.balance = balance;
        this.pin = pin;
    }

    @Override
    public boolean validate(double amount) {
        return amount > 0 && balance >= amount;
    }

    @Override
    public void pay(double amount) {
        balance -= amount;
        System.out.println("Pembayaran debit berhasil, sisa saldo: " + balance);
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of(AuthorizationMethod.PIN);
    }

    @Override
    public boolean canPay(double amount) {
        return amount > 0 && amount <= 10000000;
    }
}
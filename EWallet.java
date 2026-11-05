import java.util.List;

public class EWallet implements PaymentStrategy {
    String phoneNumber;
    double balance;
    String pin;

    public EWallet(String phoneNumber, double balance, String pin) {
        this.phoneNumber = phoneNumber;
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
        System.out.println("Pembayaran E-Wallet berhasil, sisa saldo: " + balance);
    }

    @Override
    public List<AuthorizationMethod> getRequiredAuthorizations() {
        return List.of(
                AuthorizationMethod.PIN,
                AuthorizationMethod.OTP
        );
    }

    @Override
    public boolean canPay(double amount) {
        return amount > 0 && amount <= 10000000;
    }
}
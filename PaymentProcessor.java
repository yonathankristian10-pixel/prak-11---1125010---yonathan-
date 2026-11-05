import java.util.List;
import java.util.Scanner;

public class PaymentProcessor {
    private Scanner input = new Scanner(System.in);

    public void processPayment(PaymentStrategy strategy, double amount) {
        if (!strategy.validate(amount)) {
            System.out.println("Pembayaran gagal.");
            return;
        }

        List<AuthorizationMethod> requiredAuthorizations =
                strategy.getRequiredAuthorizations();

        for (AuthorizationMethod authorization : requiredAuthorizations) {
            if (authorization == AuthorizationMethod.PIN) {
                System.out.print("Masukkan PIN: ");
                String pin = input.next();

                if (!pin.equals(getPin(strategy))) {
                    System.out.println("PIN tidak valid.");
                    return;
                }
            } else if (authorization == AuthorizationMethod.CCV) {
                System.out.print("Masukkan CCV: ");
                String ccv = input.next();

                if (!ccv.equals(getCcv(strategy))) {
                    System.out.println("CCV tidak valid.");
                    return;
                }
            }
        }

        strategy.pay(amount);
    }

    private String getPin(PaymentStrategy strategy) {
        if (strategy instanceof DebitCard) {
            return ((DebitCard) strategy).pin;
        }

        if (strategy instanceof CreditCard) {
            return ((CreditCard) strategy).pin;
        }

        return "";
    }

    private String getCcv(PaymentStrategy strategy) {
        if (strategy instanceof CreditCard) {
            return ((CreditCard) strategy).ccv;
        }

        return "";
    }
}
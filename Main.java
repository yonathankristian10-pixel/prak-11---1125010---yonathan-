import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        ArrayList<PaymentStrategy> payments = new ArrayList<>();

        payments.add(new Wallet("Main Wallet", 10000));
        payments.add(new DebitCard("123456789", 100000, "1234"));
        payments.add(new CreditCard("987654321", 500000, "123", "5678"));
        payments.add(new EWallet("081234567890", 200000, "1122"));

        PaymentProcessor processor = new PaymentProcessor();

        while (true) {
            System.out.println("1. Buat Pembayaran");
            System.out.println("2. Keluar");
            System.out.print("Pilihan: ");

            int choice = input.nextInt();

            if (choice == 1) {
                System.out.print("Masukkan jumlah pembayaran: ");
                double amount = input.nextDouble();

             for (int i = 0; i < payments.size(); i++) {
                if (payments.get(i).canPay(amount)) {
                    System.out.println((i + 1) + ". " +
                         payments.get(i).getClass().getSimpleName());
    }
}

                System.out.print("Pilih pembayaran: ");
                int paymentChoice = input.nextInt();

                if (paymentChoice > 0 && paymentChoice <= payments.size()) {
                    PaymentStrategy selected = payments.get(paymentChoice - 1);

                    if (selected.canPay(amount)) {
                     processor.processPayment(selected, amount);
                     } else {
                     System.out.println("Metode pembayaran tidak tersedia untuk nominal ini.");
                    }
                } else {
                     System.out.println("Pilihan tidak valid.");
                }

            } else if (choice == 2) {
                break;
            }
        }

        input.close();
    }
}
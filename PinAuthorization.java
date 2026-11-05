public class PinAuthorization implements AuthorizationStrategy {
    String pin;

    public PinAuthorization(String pin) {
        this.pin = pin;
    }

    @Override
    public boolean authorize(String value) {
        return pin.equals(value);
    }
}
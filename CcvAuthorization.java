public class CcvAuthorization implements AuthorizationStrategy {
    String ccv;

    public CcvAuthorization(String ccv) {
        this.ccv = ccv;
    }

    @Override
    public boolean authorize(String value) {
        return ccv.equals(value);
    }
}
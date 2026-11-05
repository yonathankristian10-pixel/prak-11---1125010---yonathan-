public class OtpAuthorization implements AuthorizationStrategy {
    String otp;

    public OtpAuthorization(String otp) {
        this.otp = otp;
    }

    @Override
    public boolean authorize(String value) {
        return otp.equals(value);
    }
}
public interface AuthorizationStrategy {
    boolean authorize(String value);
}
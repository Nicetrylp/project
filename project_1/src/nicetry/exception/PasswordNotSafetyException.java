package nicetry.exception;

public class PasswordNotSafetyException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码不安全";
    }
}

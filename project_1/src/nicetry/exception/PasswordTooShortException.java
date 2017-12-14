package nicetry.exception;

public class PasswordTooShortException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码不能少于6位";
    }
}

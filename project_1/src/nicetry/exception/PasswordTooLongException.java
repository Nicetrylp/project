package nicetry.exception;

public class PasswordTooLongException extends RegisterException {
    @Override
    public String getMessage() {
        return "密码不能超过14位";
    }
}

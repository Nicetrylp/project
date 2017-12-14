package nicetry.exception;

public class UserNameNotFoundException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名未找到...";
    }
}

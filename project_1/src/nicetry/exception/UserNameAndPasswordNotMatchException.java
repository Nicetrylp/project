package nicetry.exception;

public class UserNameAndPasswordNotMatchException extends LoginException {
    @Override
    public String getMessage() {
        return "用户名和密码不匹配...";
    }
}

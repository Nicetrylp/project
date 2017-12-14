package nicetry.exception;

public class UserNameFormatErrorException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名只能是手机号或邮箱号";
    }
}

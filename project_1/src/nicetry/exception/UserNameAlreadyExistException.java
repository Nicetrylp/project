package nicetry.exception;

public class UserNameAlreadyExistException extends RegisterException {
    @Override
    public String getMessage() {
        return "用户名已存在";
    }
}

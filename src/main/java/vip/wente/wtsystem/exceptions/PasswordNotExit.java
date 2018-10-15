package vip.wente.wtsystem.exceptions;

/**
 * @program: WtSystem
 * @description: 密码不正确
 * @author: Sonxnos7
 * @create: 2018-10-14 10:37
 **/

public class PasswordNotExit extends ServiceException {
    public PasswordNotExit() {
        super();
    }

    public PasswordNotExit(String message) {
        super(message);
    }

    public PasswordNotExit(String message, Throwable cause) {
        super(message, cause);
    }

    public PasswordNotExit(Throwable cause) {
        super(cause);
    }

    public PasswordNotExit(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

package vip.wente.wtsystem.exceptions;

/**
 * @program: WtSystem
 * @description:
 * @author: Sonxnos7
 * @create: 2018-10-10 13:34
 **/

public class UsernameConflictException extends ServiceException{
    private static final long serialVersionUID = -935760340922600036L;

    public UsernameConflictException() {
        super();
    }

    public UsernameConflictException(String message, Throwable cause, boolean enableSuppression,
                                     boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public UsernameConflictException(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameConflictException(String message) {
        super(message);
    }

    public UsernameConflictException(Throwable cause) {
        super(cause);
    }
}

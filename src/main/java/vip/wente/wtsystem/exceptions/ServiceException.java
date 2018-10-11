package vip.wente.wtsystem.exceptions;

/**
 * @program: WtSystem
 * @description: 异常
 * @author: Sonxnos7
 * @create: 2018-10-10 13:19
 **/

public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = -2879099986352308425L;
    public ServiceException() {
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }

    public ServiceException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

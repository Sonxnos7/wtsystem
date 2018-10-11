package vip.wente.wtsystem.exceptions;

/**
 * @program: WtSystem
 * @description: 用户名不能为空
 * @author: Sonxnos7
 * @create: 2018-10-10 17:02
 **/

public class UsernameIsNll extends ServiceException{
    public UsernameIsNll() {
        super();
    }

    public UsernameIsNll(String message) {
        super(message);
    }

    public UsernameIsNll(String message, Throwable cause) {
        super(message, cause);
    }

    public UsernameIsNll(Throwable cause) {
        super(cause);
    }

    public UsernameIsNll(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}

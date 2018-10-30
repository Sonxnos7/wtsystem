package vip.wente.wtsystem.entity;

/**
 * @program: WtSystem
 * @description:
 * @author: Sonxnos7
 * @create: 2018-10-10 13:57
 **/

public class ResponseResult<T> {
    public static final int STAT_OK=1;
    public static final int STAT_ERR=0;
    private Integer code;
    private String message;
    private T data;

    public ResponseResult() {
        super();
    }

    public ResponseResult(Integer code) {
        super();
        this.code = code;
    }

    public ResponseResult(Integer code, String message) {
        super();
        this.code = code;
        this.message = message;
    }

    public ResponseResult(Integer code, T data) {
        super();
        this.code = code;
        this.data = data;
    }
    public ResponseResult(Throwable throwable) {
        super();
        this.code=STAT_ERR;
        this.message=throwable.getMessage();
    }
    public Integer getState() {
        return code;
    }
    public void setState(Integer code) {
        this.code = code;
    }
    public String getMessage() {
        return message;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public T getData() {
        return data;
    }
    public void setData(T data) {
        this.data = data;
    }
}

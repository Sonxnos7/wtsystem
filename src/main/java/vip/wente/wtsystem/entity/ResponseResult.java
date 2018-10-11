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
    private Integer state;
    private String message;
    private T data;

    public ResponseResult() {
        super();
    }

    public ResponseResult(Integer state) {
        super();
        this.state = state;
    }

    public ResponseResult(Integer state, String message) {
        super();
        this.state = state;
        this.message = message;
    }

    public ResponseResult(Integer state, T data) {
        super();
        this.state = state;
        this.data = data;
    }
    public ResponseResult(Throwable throwable) {
        super();
        this.state=STAT_ERR;
        this.message=throwable.getMessage();
    }
    public Integer getState() {
        return state;
    }
    public void setState(Integer state) {
        this.state = state;
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

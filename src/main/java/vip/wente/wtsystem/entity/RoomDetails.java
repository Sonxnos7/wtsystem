package vip.wente.wtsystem.entity;

import java.io.Serializable;

/**
 * @program: WtSystem
 * @description: 房间关联类
 * @author: Sonxnos7
 * @create: 2018-10-16 18:22
 **/

public class RoomDetails implements Serializable {
    private static final long serialVersionUID = -4935243293906812570L;
    private Integer id;
    private Integer type;
    private String details;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getDetails() {
        return details;
    }

    public void setDetails(String details) {
        this.details = details;
    }

    @Override
    public String toString() {
        return "RoomDetails{" +
                "id=" + id +
                ", type=" + type +
                ", details='" + details + '\'' +
                '}';
    }
}

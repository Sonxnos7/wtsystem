package vip.wente.wtsystem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: WtSystem
 * @description: 房间实体类
 * @author: Sonxnos7
 * @create: 2018-10-12 18:03
 **/

public class Room implements Serializable {
    private static final long serialVersionUID = -4935243293906812580L;
    private Integer id;
    private Integer  shopNumber;
    private String  roomNumber;
    private Integer  roomAmount;
    //房态ID 0 空房可住，1 已经入住，2 已被预订，3 正在打扫，4 正在维修',
    private Integer  roomStateID;
    private double   standardPriceDay;
    private Date createdTime;
    private String createdUser;
    private String modifiedUser;
    private Date modifiedTime;

    public Integer getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(Integer shopNumber) {
        this.shopNumber = shopNumber;
    }

    public Date getCreatedTime() {
        return createdTime;
    }

    public void setCreatedTime(Date createdTime) {
        this.createdTime = createdTime;
    }

    public String getCreatedUser() {
        return createdUser;
    }

    public void setCreatedUser(String createdUser) {
        this.createdUser = createdUser;
    }

    public String getModifiedUser() {
        return modifiedUser;
    }

    public void setModifiedUser(String modifiedUser) {
        this.modifiedUser = modifiedUser;
    }

    public Date getModifiedTime() {
        return modifiedTime;
    }

    public void setModifiedTime(Date modifiedTime) {
        this.modifiedTime = modifiedTime;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getRoomNumber() {
        return roomNumber;
    }

    public void setRoomNumber(String roomNumber) {
        this.roomNumber = roomNumber;
    }

    public Integer getRoomAmount() {
        return roomAmount;
    }

    public void setRoomAmount(Integer roomAmount) {
        this.roomAmount = roomAmount;
    }

    public Integer getRoomStateID() {
        return roomStateID;
    }

    public void setRoomStateID(Integer roomStateID) {
        this.roomStateID = roomStateID;
    }

    public double getStandardPriceDay() {
        return standardPriceDay;
    }

    public void setStandardPriceDay(double standardPriceDay) {
        this.standardPriceDay = standardPriceDay;
    }


    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", shopNumber=" + shopNumber +
                ", roomNumber=" + roomNumber +
                ", roomAmount=" + roomAmount +
                ", roomStateID=" + roomStateID +
                ", standardPriceDay=" + standardPriceDay +
                ", createdTime=" + createdTime +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}

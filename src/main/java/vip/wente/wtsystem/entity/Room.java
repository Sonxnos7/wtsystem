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
    private Integer roomState;
    private String state;
    private Integer roomType;
    private String type;
    private Integer  shopNumber;
    private String  roomNumber;
    private Integer  roomAmount;
    private double   standardPriceDay;
    private double   vipPriceDay;
    private Date createdTime;
    private String createdUser;
    private String modifiedUser;
    private Date modifiedTime;

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRoomState() {
        return roomState;
    }

    public void setRoomState(Integer roomState) {
        this.roomState = roomState;
    }

    public Integer getRoomType() {
        return roomType;
    }

    public void setRoomType(Integer roomType) {
        this.roomType = roomType;
    }

    public double getVipPriceDay() {
        return vipPriceDay;
    }

    public void setVipPriceDay(double vipPriceDay) {
        this.vipPriceDay = vipPriceDay;
    }

    public Integer getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(Integer shopNumber) {
        this.shopNumber = shopNumber;
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

    public double getStandardPriceDay() {
        return standardPriceDay;
    }

    public void setStandardPriceDay(double standardPriceDay) {
        this.standardPriceDay = standardPriceDay;
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

    @Override
    public String toString() {
        return "Room{" +
                "id=" + id +
                ", roomState=" + roomState +
                ", state='" + state + '\'' +
                ", roomType=" + roomType +
                ", type='" + type + '\'' +
                ", shopNumber=" + shopNumber +
                ", roomNumber='" + roomNumber + '\'' +
                ", roomAmount=" + roomAmount +
                ", standardPriceDay=" + standardPriceDay +
                ", vipPriceDay=" + vipPriceDay +
                ", createdTime=" + createdTime +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}

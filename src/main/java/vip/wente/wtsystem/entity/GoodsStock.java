package vip.wente.wtsystem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: WtSystem
 * @description: 商品库存
 * @author: Sonxnos7
 * @create: 2018-10-30 15:03
 **/

public class GoodsStock implements Serializable {
    private static final long serialVersionUID = -4935243293985112580L;
    private Integer id;
    private Integer shopNumber;
    private String name;
    private Integer type;
    private Integer number;
    private double price;
    private String em;
    private Date createdTime;
    private String createdUser;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getShopNumber() {
        return shopNumber;
    }

    public void setShopNumber(Integer shopNumber) {
        this.shopNumber = shopNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getEm() {
        return em;
    }

    public void setEm(String em) {
        this.em = em;
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

    @Override
    public String toString() {
        return "GoodsStock{" +
                "id=" + id +
                ", shopNumber=" + shopNumber +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", number=" + number +
                ", price=" + price +
                ", em='" + em + '\'' +
                ", createdTime=" + createdTime +
                ", createdUser='" + createdUser + '\'' +
                '}';
    }
}

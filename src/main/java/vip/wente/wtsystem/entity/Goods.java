package vip.wente.wtsystem.entity;

import java.io.Serializable;

/**
 * @program: WtSystem
 * @description: 商品表
 * @author: Sonxnos7
 * @create: 2018-10-17 19:20
 **/

public class Goods implements Serializable {
    private static final long serialVersionUID = -4935243293985812580L;
    private Integer id;
    private Integer shopNumber;
    private String name;
    private Integer type;
    private String typeName;
    private Integer em;
    private String emName;
    private double price;
    private Integer amount;

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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public Integer getEm() {
        return em;
    }

    public void setEm(Integer em) {
        this.em = em;
    }

    public String getEmName() {
        return emName;
    }

    public void setEmName(String emName) {
        this.emName = emName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", shopNumber=" + shopNumber +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", typeName='" + typeName + '\'' +
                ", em=" + em +
                ", emName='" + emName + '\'' +
                ", price=" + price +
                ", amount=" + amount +
                '}';
    }
}

package vip.wente.wtsystem.entity;

import java.io.Serializable;
import java.util.Date;

/**
 * @program: WtSystem
 * @description: 会员
 * @author: Sonxnos7
 * @create: 2018-10-23 09:52
 **/

public class Member implements Serializable {
    private static final long serialVersionUID = -4935243293985812580L;
    private Integer id;
    private Integer sex;
    private String sexName;
    private Integer shopNumber;
    private String name;
    private String birth;
    private String nation;
    private String provate;
    private String intime;
    private Integer type;
    private String typeName;
    private String number;
    private Integer lever;
    private String leverName;
    private String phone;
    private String other;
    private Date createdTime;
    private String createdUser;
    private String modifiedUser;
    private Date modifiedTime;

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getSexName() {
        return sexName;
    }

    public void setSexName(String sexName) {
        this.sexName = sexName;
    }

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

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getNation() {
        return nation;
    }

    public void setNation(String nation) {
        this.nation = nation;
    }

    public String getProvate() {
        return provate;
    }

    public void setProvate(String provate) {
        this.provate = provate;
    }

    public String getIntime() {
        return intime;
    }

    public void setIntime(String intime) {
        this.intime = intime;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public Integer getLever() {
        return lever;
    }

    public void setLever(Integer lever) {
        this.lever = lever;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getOther() {
        return other;
    }

    public void setOther(String other) {
        this.other = other;
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

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getLeverName() {
        return leverName;
    }

    public void setLeverName(String leverName) {
        this.leverName = leverName;
    }

    @Override
    public String toString() {
        return "Member{" +
                "id=" + id +
                ", sex=" + sex +
                ", sexName='" + sexName + '\'' +
                ", shopNumber=" + shopNumber +
                ", name='" + name + '\'' +
                ", birth='" + birth + '\'' +
                ", nation='" + nation + '\'' +
                ", provate='" + provate + '\'' +
                ", intime='" + intime + '\'' +
                ", type=" + type +
                ", typeName='" + typeName + '\'' +
                ", number='" + number + '\'' +
                ", lever=" + lever +
                ", leverName='" + leverName + '\'' +
                ", phone='" + phone + '\'' +
                ", other='" + other + '\'' +
                ", createdTime=" + createdTime +
                ", createdUser='" + createdUser + '\'' +
                ", modifiedUser='" + modifiedUser + '\'' +
                ", modifiedTime=" + modifiedTime +
                '}';
    }
}

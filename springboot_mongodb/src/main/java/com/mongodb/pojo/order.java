package com.mongodb.pojo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;
import java.util.List;

public class order {
    private int id;//订单id
    private String status;//状态
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date orderTime;//下单时间
    private String shipper;//发货人
    private String shippingAdress;//发货地址
    private long shipperPhone;//发货人手机
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm",timezone = "GMT+8")
    private Date shipTime;//发货时间
    private String recevier;//接收人
    private String recevierAddress;//接收地址
    private long receviePhone;//接收人号码
    private List<logistics>logistics;//物流信息

    @Override
    public String toString() {
        return "order{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", orderTime=" + orderTime +
                ", shipper='" + shipper + '\'' +
                ", shippingAdress='" + shippingAdress + '\'' +
                ", shipperPhone=" + shipperPhone +
                ", shipTime=" + shipTime +
                ", recevier='" + recevier + '\'' +
                ", recevierAddress='" + recevierAddress + '\'' +
                ", receviePhone=" + receviePhone +
                ", logistics=" + logistics +
                '}';
    }

    public order(int id, String status, Date orderTime, String shipper, String shippingAdress, long shipperPhone, Date shipTime, String recevier, String recevierAddress, long receviePhone, List<logistics> logistics) {
        this.id = id;
        this.status = status;
        this.orderTime = orderTime;
        this.shipper = shipper;
        this.shippingAdress = shippingAdress;
        this.shipperPhone = shipperPhone;
        this.shipTime = shipTime;
        this.recevier = recevier;
        this.recevierAddress = recevierAddress;
        this.receviePhone = receviePhone;
        this.logistics = logistics;
    }

    public order() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public String getShipper() {
        return shipper;
    }

    public void setShipper(String shipper) {
        this.shipper = shipper;
    }

    public String getShippingAdress() {
        return shippingAdress;
    }

    public void setShippingAdress(String shippingAdress) {
        this.shippingAdress = shippingAdress;
    }

    public long getShipperPhone() {
        return shipperPhone;
    }

    public void setShipperPhone(long shipperPhone) {
        this.shipperPhone = shipperPhone;
    }

    public Date getShipTime() {
        return shipTime;
    }

    public void setShipTime(Date shipTime) {
        this.shipTime = shipTime;
    }

    public String getRecevier() {
        return recevier;
    }

    public void setRecevier(String recevier) {
        this.recevier = recevier;
    }

    public String getRecevierAddress() {
        return recevierAddress;
    }

    public void setRecevierAddress(String recevierAddress) {
        this.recevierAddress = recevierAddress;
    }

    public long getReceviePhone() {
        return receviePhone;
    }

    public void setReceviePhone(long receviePhone) {
        this.receviePhone = receviePhone;
    }

    public List<logistics> getLogistics() {
        return logistics;
    }

    public void setLogistics(List<logistics> logistics) {
        this.logistics = logistics;
    }
}

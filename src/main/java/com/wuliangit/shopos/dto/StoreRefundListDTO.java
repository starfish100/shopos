package com.wuliangit.shopos.dto;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author pangweichao
 * @description 退换货列表数据
 * @create 2017-05-12 9:41
 **/
public class StoreRefundListDTO {

    private Integer refundId;

    private Integer orderId;

    private String orderOutTradeNo;

    private Integer storeId;

    private Integer memberId;

    private String memberUsername;

    private Integer goodsId;

    private String goodsName;

    private Integer goodsNum;

    private BigDecimal refundAmount;

    private String goodsImage;

    private String orderGoodsType;

    private String refundType;

    private String refundState;

    private Boolean isLock;

    private String goodsState;

    private Date createTime;

    private Date sellerHandleTime;

    private Date adminTime;

    private String picsInfo;

    private String buyerMessage;

    private String sellerMessage;

    private String expressName;

    private String expressNo;

    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getRefundId() {
        return refundId;
    }

    public void setRefundId(Integer refundId) {
        this.refundId = refundId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public String getOrderOutTradeNo() {
        return orderOutTradeNo;
    }

    public void setOrderOutTradeNo(String orderOutTradeNo) {
        this.orderOutTradeNo = orderOutTradeNo;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getMemberId() {
        return memberId;
    }

    public void setMemberId(Integer memberId) {
        this.memberId = memberId;
    }

    public String getMemberUsername() {
        return memberUsername;
    }

    public void setMemberUsername(String memberUsername) {
        this.memberUsername = memberUsername;
    }

    public Integer getGoodsId() {
        return goodsId;
    }

    public void setGoodsId(Integer goodsId) {
        this.goodsId = goodsId;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

    public BigDecimal getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(BigDecimal refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getGoodsImage() {
        return goodsImage;
    }

    public void setGoodsImage(String goodsImage) {
        this.goodsImage = goodsImage;
    }

    public String getOrderGoodsType() {
        return orderGoodsType;
    }

    public void setOrderGoodsType(String orderGoodsType) {
        this.orderGoodsType = orderGoodsType;
    }

    public String getRefundType() {
        return refundType;
    }

    public void setRefundType(String refundType) {
        this.refundType = refundType;
    }

    public String getRefundState() {
        return refundState;
    }

    public void setRefundState(String refundState) {
        this.refundState = refundState;
    }

    public Boolean getLock() {
        return isLock;
    }

    public void setLock(Boolean lock) {
        isLock = lock;
    }

    public String getGoodsState() {
        return goodsState;
    }

    public void setGoodsState(String goodsState) {
        this.goodsState = goodsState;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getSellerHandleTime() {
        return sellerHandleTime;
    }

    public void setSellerHandleTime(Date sellerHandleTime) {
        this.sellerHandleTime = sellerHandleTime;
    }

    public Date getAdminTime() {
        return adminTime;
    }

    public void setAdminTime(Date adminTime) {
        this.adminTime = adminTime;
    }

    public String getPicsInfo() {
        return picsInfo;
    }

    public void setPicsInfo(String picsInfo) {
        this.picsInfo = picsInfo;
    }

    public String getBuyerMessage() {
        return buyerMessage;
    }

    public void setBuyerMessage(String buyerMessage) {
        this.buyerMessage = buyerMessage;
    }

    public String getSellerMessage() {
        return sellerMessage;
    }

    public void setSellerMessage(String sellerMessage) {
        this.sellerMessage = sellerMessage;
    }

    public String getExpressName() {
        return expressName;
    }

    public void setExpressName(String expressName) {
        this.expressName = expressName;
    }

    public String getExpressNo() {
        return expressNo;
    }

    public void setExpressNo(String expressNo) {
        this.expressNo = expressNo;
    }
}

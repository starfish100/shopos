package com.wuliangit.shopos.model;

/**
 * Created by nilme on 2017/5/5.
 */
public class OrderGoodsInfo {

    private Integer goodsSkuId;

    private Integer goodsNum;

    public OrderGoodsInfo() {
    }

    public OrderGoodsInfo(Integer goodsSkuId, Integer goodsNum) {
        this.goodsSkuId = goodsSkuId;
        this.goodsNum = goodsNum;
    }

    public Integer getGoodsSkuId() {
        return goodsSkuId;
    }

    public void setGoodsSkuId(Integer goodsSkuId) {
        this.goodsSkuId = goodsSkuId;
    }

    public Integer getGoodsNum() {
        return goodsNum;
    }

    public void setGoodsNum(Integer goodsNum) {
        this.goodsNum = goodsNum;
    }

}

package com.wuliangit.shopos.entity;

import java.math.BigDecimal;
import java.util.Date;

public class Store {
    private Integer storeId;

    private String sellerAdminId;

    private Integer bindMemberId;

    private String bindMemberUsername;

    private String name;

    private Integer grade;

    private Integer scId;

    private String type;

    private String storeCompanyName;

    private Integer provinceId;

    private String areaInfo;

    private String address;

    private String zip;

    private String state;

    private String closeInfo;

    private Integer sort;

    private Date createTime;

    private String endTime;

    private String label;

    private String banner;

    private String logo;

    private String keywords;

    private String description;

    private String qq;

    private String ww;

    private String phone;

    private String domain;

    private Integer domainTimes;

    private Boolean isRecommend;

    private String theme;

    private Integer credit;

    private Double desccredit;

    private Float servicecredit;

    private Float deliverycredit;

    private Integer collect;

    private String slideUrl;

    private String stamp;

    private String printdesc;

    private Integer sales;

    private String presales;

    private String aftersales;

    private String workingtime;

    private BigDecimal freePrice;

    private Boolean decorationSwitch;

    private Boolean decorationOnly;

    private Boolean sevenDayReturn;

    private Boolean realGoods;

    private Boolean salesReturn;

    private Boolean live;

    private Boolean payAfter;

    private String storeFreeTime;

    private String liveStoreName;

    private String liveStoreAddress;

    private String liveStoreTel;

    private Double liveStoreGpsLng;

    private Double liveStoreGpsLat;

    private String liveStoreBus;

    private String refundAddress;

    private String refundName;

    private String refundPhone;

    private Boolean guaranteeMoney;

    private Integer orderAmount;

    private Long tradingVolume;

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public String getSellerAdminId() {
        return sellerAdminId;
    }

    public void setSellerAdminId(String sellerAdminId) {
        this.sellerAdminId = sellerAdminId == null ? null : sellerAdminId.trim();
    }

    public Integer getBindMemberId() {
        return bindMemberId;
    }

    public void setBindMemberId(Integer bindMemberId) {
        this.bindMemberId = bindMemberId;
    }

    public String getBindMemberUsername() {
        return bindMemberUsername;
    }

    public void setBindMemberUsername(String bindMemberUsername) {
        this.bindMemberUsername = bindMemberUsername == null ? null : bindMemberUsername.trim();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Integer getScId() {
        return scId;
    }

    public void setScId(Integer scId) {
        this.scId = scId;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    public String getStoreCompanyName() {
        return storeCompanyName;
    }

    public void setStoreCompanyName(String storeCompanyName) {
        this.storeCompanyName = storeCompanyName == null ? null : storeCompanyName.trim();
    }

    public Integer getProvinceId() {
        return provinceId;
    }

    public void setProvinceId(Integer provinceId) {
        this.provinceId = provinceId;
    }

    public String getAreaInfo() {
        return areaInfo;
    }

    public void setAreaInfo(String areaInfo) {
        this.areaInfo = areaInfo == null ? null : areaInfo.trim();
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip == null ? null : zip.trim();
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state == null ? null : state.trim();
    }

    public String getCloseInfo() {
        return closeInfo;
    }

    public void setCloseInfo(String closeInfo) {
        this.closeInfo = closeInfo == null ? null : closeInfo.trim();
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getEndTime() {
        return endTime;
    }

    public void setEndTime(String endTime) {
        this.endTime = endTime == null ? null : endTime.trim();
    }

    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label == null ? null : label.trim();
    }

    public String getBanner() {
        return banner;
    }

    public void setBanner(String banner) {
        this.banner = banner == null ? null : banner.trim();
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo == null ? null : logo.trim();
    }

    public String getKeywords() {
        return keywords;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords == null ? null : keywords.trim();
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description == null ? null : description.trim();
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq == null ? null : qq.trim();
    }

    public String getWw() {
        return ww;
    }

    public void setWw(String ww) {
        this.ww = ww == null ? null : ww.trim();
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    public String getDomain() {
        return domain;
    }

    public void setDomain(String domain) {
        this.domain = domain == null ? null : domain.trim();
    }

    public Integer getDomainTimes() {
        return domainTimes;
    }

    public void setDomainTimes(Integer domainTimes) {
        this.domainTimes = domainTimes;
    }

    public Boolean getIsRecommend() {
        return isRecommend;
    }

    public void setIsRecommend(Boolean isRecommend) {
        this.isRecommend = isRecommend;
    }

    public String getTheme() {
        return theme;
    }

    public void setTheme(String theme) {
        this.theme = theme == null ? null : theme.trim();
    }

    public Integer getCredit() {
        return credit;
    }

    public void setCredit(Integer credit) {
        this.credit = credit;
    }

    public Double getDesccredit() {
        return desccredit;
    }

    public void setDesccredit(Double desccredit) {
        this.desccredit = desccredit;
    }

    public Float getServicecredit() {
        return servicecredit;
    }

    public void setServicecredit(Float servicecredit) {
        this.servicecredit = servicecredit;
    }

    public Float getDeliverycredit() {
        return deliverycredit;
    }

    public void setDeliverycredit(Float deliverycredit) {
        this.deliverycredit = deliverycredit;
    }

    public Integer getCollect() {
        return collect;
    }

    public void setCollect(Integer collect) {
        this.collect = collect;
    }

    public String getSlideUrl() {
        return slideUrl;
    }

    public void setSlideUrl(String slideUrl) {
        this.slideUrl = slideUrl == null ? null : slideUrl.trim();
    }

    public String getStamp() {
        return stamp;
    }

    public void setStamp(String stamp) {
        this.stamp = stamp == null ? null : stamp.trim();
    }

    public String getPrintdesc() {
        return printdesc;
    }

    public void setPrintdesc(String printdesc) {
        this.printdesc = printdesc == null ? null : printdesc.trim();
    }

    public Integer getSales() {
        return sales;
    }

    public void setSales(Integer sales) {
        this.sales = sales;
    }

    public String getPresales() {
        return presales;
    }

    public void setPresales(String presales) {
        this.presales = presales == null ? null : presales.trim();
    }

    public String getAftersales() {
        return aftersales;
    }

    public void setAftersales(String aftersales) {
        this.aftersales = aftersales == null ? null : aftersales.trim();
    }

    public String getWorkingtime() {
        return workingtime;
    }

    public void setWorkingtime(String workingtime) {
        this.workingtime = workingtime == null ? null : workingtime.trim();
    }

    public BigDecimal getFreePrice() {
        return freePrice;
    }

    public void setFreePrice(BigDecimal freePrice) {
        this.freePrice = freePrice;
    }

    public Boolean getDecorationSwitch() {
        return decorationSwitch;
    }

    public void setDecorationSwitch(Boolean decorationSwitch) {
        this.decorationSwitch = decorationSwitch;
    }

    public Boolean getDecorationOnly() {
        return decorationOnly;
    }

    public void setDecorationOnly(Boolean decorationOnly) {
        this.decorationOnly = decorationOnly;
    }

    public Boolean getSevenDayReturn() {
        return sevenDayReturn;
    }

    public void setSevenDayReturn(Boolean sevenDayReturn) {
        this.sevenDayReturn = sevenDayReturn;
    }

    public Boolean getRealGoods() {
        return realGoods;
    }

    public void setRealGoods(Boolean realGoods) {
        this.realGoods = realGoods;
    }

    public Boolean getSalesReturn() {
        return salesReturn;
    }

    public void setSalesReturn(Boolean salesReturn) {
        this.salesReturn = salesReturn;
    }

    public Boolean getLive() {
        return live;
    }

    public void setLive(Boolean live) {
        this.live = live;
    }

    public Boolean getPayAfter() {
        return payAfter;
    }

    public void setPayAfter(Boolean payAfter) {
        this.payAfter = payAfter;
    }

    public String getStoreFreeTime() {
        return storeFreeTime;
    }

    public void setStoreFreeTime(String storeFreeTime) {
        this.storeFreeTime = storeFreeTime == null ? null : storeFreeTime.trim();
    }

    public String getLiveStoreName() {
        return liveStoreName;
    }

    public void setLiveStoreName(String liveStoreName) {
        this.liveStoreName = liveStoreName == null ? null : liveStoreName.trim();
    }

    public String getLiveStoreAddress() {
        return liveStoreAddress;
    }

    public void setLiveStoreAddress(String liveStoreAddress) {
        this.liveStoreAddress = liveStoreAddress == null ? null : liveStoreAddress.trim();
    }

    public String getLiveStoreTel() {
        return liveStoreTel;
    }

    public void setLiveStoreTel(String liveStoreTel) {
        this.liveStoreTel = liveStoreTel == null ? null : liveStoreTel.trim();
    }

    public Double getLiveStoreGpsLng() {
        return liveStoreGpsLng;
    }

    public void setLiveStoreGpsLng(Double liveStoreGpsLng) {
        this.liveStoreGpsLng = liveStoreGpsLng;
    }

    public Double getLiveStoreGpsLat() {
        return liveStoreGpsLat;
    }

    public void setLiveStoreGpsLat(Double liveStoreGpsLat) {
        this.liveStoreGpsLat = liveStoreGpsLat;
    }

    public String getLiveStoreBus() {
        return liveStoreBus;
    }

    public void setLiveStoreBus(String liveStoreBus) {
        this.liveStoreBus = liveStoreBus == null ? null : liveStoreBus.trim();
    }

    public String getRefundAddress() {
        return refundAddress;
    }

    public void setRefundAddress(String refundAddress) {
        this.refundAddress = refundAddress == null ? null : refundAddress.trim();
    }

    public String getRefundName() {
        return refundName;
    }

    public void setRefundName(String refundName) {
        this.refundName = refundName == null ? null : refundName.trim();
    }

    public String getRefundPhone() {
        return refundPhone;
    }

    public void setRefundPhone(String refundPhone) {
        this.refundPhone = refundPhone == null ? null : refundPhone.trim();
    }

    public Boolean getGuaranteeMoney() {
        return guaranteeMoney;
    }

    public void setGuaranteeMoney(Boolean guaranteeMoney) {
        this.guaranteeMoney = guaranteeMoney;
    }

    public Integer getOrderAmount() {
        return orderAmount;
    }

    public void setOrderAmount(Integer orderAmount) {
        this.orderAmount = orderAmount;
    }

    public Long getTradingVolume() {
        return tradingVolume;
    }

    public void setTradingVolume(Long tradingVolume) {
        this.tradingVolume = tradingVolume;
    }
}
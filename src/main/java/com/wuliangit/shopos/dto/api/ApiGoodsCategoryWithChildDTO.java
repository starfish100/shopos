package com.wuliangit.shopos.dto.api;

import java.util.List;

/**
 * Created by nilme on 2017/5/14.
 */
public class ApiGoodsCategoryWithChildDTO {

    private Integer goodsCategoryId;

    private String name;

    private String img;

    private List<ApiGoodsCategoryDOT> categories;

    public Integer getGoodsCategoryId() {
        return goodsCategoryId;
    }

    public void setGoodsCategoryId(Integer goodsCategoryId) {
        this.goodsCategoryId = goodsCategoryId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public List<ApiGoodsCategoryDOT> getCategories() {
        return categories;
    }

    public void setCategories(List<ApiGoodsCategoryDOT> categories) {
        this.categories = categories;
    }
}

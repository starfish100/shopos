package com.wuliangit.shopos.service;

import com.wuliangit.shopos.dto.ApiGoodsListDTO;
import com.wuliangit.shopos.entity.Goods;

import java.util.ArrayList;

/**
 * Created by nilme on 2017/3/30.
 */
public interface GoodsService {
    /**
     * 首页获取商品（搜索）
     * @param page
     * @param pageSize
     * @param searchKey
     * @param order
     * @return
     */
    ArrayList<ApiGoodsListDTO> apiGoodsSearch(Integer page, Integer pageSize, String searchKey, String order);

    /**
     * 创建商品
     * @param goods
     * @param skuStr
     * @return
     */
    int createGoods(Goods goods, String skuStr);
}

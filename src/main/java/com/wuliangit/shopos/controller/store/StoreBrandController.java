package com.wuliangit.shopos.controller.store;

import com.wuliangit.shopos.common.POJOConstants;
import com.wuliangit.shopos.common.controller.PageResult;
import com.wuliangit.shopos.common.controller.RestResult;
import com.wuliangit.shopos.common.qiniu.QiNiuUtils;
import com.wuliangit.shopos.common.util.StringUtils;
import com.wuliangit.shopos.common.util.WebUtil;
import com.wuliangit.shopos.entity.Brand;
import com.wuliangit.shopos.entity.GoodsCategory;
import com.wuliangit.shopos.model.StoreBrand;
import com.wuliangit.shopos.model.StoreMin;
import com.wuliangit.shopos.service.BrandService;
import com.wuliangit.shopos.service.GoodsCategoryService;
import com.wuliangit.shopos.service.StoreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * Created by JangJanPing on 2017/5/1.
 *
 * @description 店铺用户的品牌操作controller
 */
@Controller
@RequestMapping("/store/brand")
public class StoreBrandController {
    @Autowired
    private StoreService storeService;
    @Autowired
    private BrandService brandService;
    @Autowired
    private GoodsCategoryService goodsCategoryService;

    /**
     * 跳转到店铺品牌页面
     *
     * @return
     */
    @RequestMapping("/listPage")
    public String jumpToBrandListPage() {
        return "/store/brand/list";
    }

    /**
     * 查询店铺品牌列表
     *
     * @param draw
     * @param searchKey
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/search")
    @ResponseBody
    public Object searchBrands(@RequestParam("draw") int draw,
                               @RequestParam(value = "searchKey", required = false) String searchKey,
                               @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                               @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize) {
        StoreMin storeMin = WebUtil.getCurrentStore();
        Integer storeId = storeMin.getStoreId();
        List<StoreBrand> storeBrands = brandService.getStoreBrands(page, pageSize, searchKey, storeId);
        return new PageResult<StoreBrand>(storeBrands, draw);
    }

    /**
     * 更改店铺某品牌上下架状态
     *
     * @param id
     * @param status
     * @return
     */
    @RequestMapping("/updateBrandStatus")
    @ResponseBody
    public Object changOnshelfStatus(Integer id, String status) {
        RestResult result = new RestResult();
        brandService.updateBrandStatus(id, status);
        return result;
    }

    /**
     * 删除某个店铺的品牌
     *
     * @param id
     * @return
     */
    @RequestMapping("/deleteBrand")
    @ResponseBody
    public Object deleteStoreBrand(Integer id) {
        RestResult result = new RestResult();
        brandService.deleteStoreBrand(id);
        return result;
    }

    /**
     * 跳转到申请入驻页面
     *
     * @return
     */
    @RequestMapping("/joinPage")
    public String jumpToDetailPage(Model model) {
        return "store/brand/join_brand";
    }

    /**
     * 获取所有品牌
     *
     * @return
     */
    @RequestMapping("/getAllAvailableBrands")
    @ResponseBody
    public Object getAllAvailableBrands() {
        RestResult result = new RestResult();
        List<Brand> brands = brandService.getAllAvailableBrands();
        result.add("brands", brands);
        return result;
    }

    /**
     * 店铺申请入驻品牌
     *
     * @return
     */
    @RequestMapping("/applyForJoinBrand")
    @ResponseBody
    public Object applyForJoinBrand(Integer brandId) {
        RestResult result = new RestResult();
        StoreMin store = WebUtil.getCurrentStore();
        Integer storeId = store.getStoreId();
        brandService.addStoreBrand(storeId, brandId);
        return result;
    }

    /**
     * 跳转到店铺添加品牌页面
     *
     * @return
     */
    @RequestMapping("/addPage")
    public String jumpToAddBrandPage(Model model) {
        model.addAttribute("uploadToken", QiNiuUtils.getToken());
        model.addAttribute("domain", QiNiuUtils.getBaseUrl());
        return "/store/brand/add";
    }

    /**
     * 验证品牌名是否存在
     *
     * @param brandName
     * @return
     */
    @RequestMapping("/checkBrandName")
    @ResponseBody
    public String checkBrandNameExistence(String brandName) {
        String message = "";
        if (brandService.hasBrandName(brandName)) {
            message = "品牌名已存在";
        } else {
            message = "可以添加该品牌名";
        }
        return message;
    }

    /**
     * 获取所有分类
     *
     * @return
     */
    @RequestMapping("/get/category")
    @ResponseBody
    public Object getAll(@RequestParam(required = true,defaultValue = "0") Integer parentId) {
        RestResult result = new RestResult();
        List<GoodsCategory> goodsCategories = goodsCategoryService.getGoodsCategoryListByParentId(parentId);
        result.add("goodsCategories", goodsCategories);
        return result;
    }

    /**
     * 店铺添加品牌
     *
     * @param brand
     * @return
     */
    @RequestMapping("/addBrand")
    @ResponseBody
    public Object addBrand(Brand brand) {
        RestResult result = new RestResult();
        StoreMin store = WebUtil.getCurrentStore();
        brand.setStoreId(store.getStoreId());
        brand.setState(POJOConstants.BRAND_STATE_APPLYING);
        brandService.addBrand(brand);
        return result;
    }

    /**
     * 跳转到店铺申请添加的品牌列表页面
     * @return
     */
    @RequestMapping("/storeAddBrandListPage")
    public String jumpToStoreAddBrandListPage(){
         return "store/brand/apply_add_brand_list";
    }
    /**
     * 店铺申请添加的品牌列表
     * @param draw
     * @param searchKey
     * @param orderColumn
     * @param orderType
     * @param page
     * @param pageSize
     * @return
     */
    @RequestMapping("/getStoreAddBransList")
    @ResponseBody
    public Object getStoreGoodsWithAd(@RequestParam("draw") int draw,
                                      @RequestParam(value = "searchKey", required = false) String searchKey,
                                      @RequestParam(value = "orderColumn", required = false) String orderColumn,
                                      @RequestParam(value = "orderType", required = false) String orderType,
                                      @RequestParam(value = "page", required = false, defaultValue = "1") Integer page,
                                      @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize){
        orderColumn = StringUtils.camelToUnderline(orderColumn);
        Integer storeId = WebUtil.getCurrentStore().getStoreId();
        List<Brand> brands = brandService.storeGetApplyAddBrands(storeId, page, pageSize, searchKey, orderColumn, orderType);
        return new PageResult<Brand>(brands,draw);
    }

    /**
     * 店铺删除申请添加的品牌
     * @param brandId
     * @return
     */
    @RequestMapping("/deleteApplyAddBrand")
    @ResponseBody
    public Object storeDeleteApplyAddBrand(Integer brandId){
         RestResult result = new RestResult();
         int res = brandService.storeDeleteApplyAddBrand(brandId);
         return result;
    }

    /**
     * 跳转到店铺重新编辑品牌页面
     * @param brandId
     * @param model
     * @return
     */
    @RequestMapping("/storeReeditApplyAddBrandPage")
    public String jumpToReeditApplyBrandPage(Integer brandId, Model model){
         Brand brand = brandService.getBrandById(brandId);
         model.addAttribute("brand", brand);
         model.addAttribute("uploadToken", QiNiuUtils.getToken());
         return "store/brand/reedit_apply_add_brand";
    }

    /**
     * 保存店铺提交重新编辑品牌信息
     * @param brand
     * @return
     */
    @RequestMapping("/storeSaveReeditInfo")
    @ResponseBody
    public Object storeSaveEditInfo(Brand brand){
        RestResult result = new RestResult();
        if (brand.getPic().length() > 0) {
            brand.setPic(QiNiuUtils.getRealUrl(brand.getPic()));
        } else {
            brand.setPic(null);
        }
        int res = brandService.storeSaveReeditBrandInfo(brand);
        return result;
    }
}

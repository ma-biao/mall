package com.mabiao.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabiao.common.to.SkuReductionTo;
import com.mabiao.common.utils.PageUtils;
import com.mabiao.mall.coupon.entity.SkuFullReductionEntity;

import java.util.Map;

/**
 * 商品满减信息
 *
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-27 10:23:23
 */
public interface SkuFullReductionService extends IService<SkuFullReductionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveSkuReduction(SkuReductionTo skuReductionTo);
}


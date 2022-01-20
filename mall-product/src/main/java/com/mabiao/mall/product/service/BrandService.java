package com.mabiao.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabiao.common.utils.PageUtils;
import com.mabiao.mall.product.entity.BrandEntity;

import java.util.Map;

/**
 * 品牌
 *
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-23 14:33:22
 */
public interface BrandService extends IService<BrandEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void updateDetail(BrandEntity brand);
}


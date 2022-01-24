package com.mabiao.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabiao.common.utils.PageUtils;
import com.mabiao.mall.product.entity.ProductAttrValueEntity;

import java.util.List;
import java.util.Map;

/**
 * spu属性值
 *
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-23 14:33:22
 */
public interface ProductAttrValueService extends IService<ProductAttrValueEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void saveProductAttr(List<ProductAttrValueEntity> collect);
}


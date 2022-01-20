package com.mabiao.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabiao.common.utils.PageUtils;
import com.mabiao.mall.product.entity.AttrGroupEntity;

import java.util.Map;

/**
 * 属性分组
 *
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-23 14:33:22
 */
public interface AttrGroupService extends IService<AttrGroupEntity> {

    PageUtils queryPage(Map<String, Object> params);

    PageUtils queryPage(Map<String, Object> params, Long categoryId);
}


package com.mabiao.mall.product.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabiao.common.utils.PageUtils;
import com.mabiao.mall.product.entity.AttrGroupEntity;
import com.mabiao.mall.product.vo.AttrGroupWithAttrsVo;
import com.mabiao.mall.product.vo.SpuItemAttrGroupVo;

import java.util.List;
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

    List<AttrGroupWithAttrsVo> getAttrGroupWithAttrsByCatelogId(Long catelogId);

    List<SpuItemAttrGroupVo> getAttrGroupWithAttrsBySpuId(Long spuId, Long catalogId);
}


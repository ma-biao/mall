package com.mabiao.mall.product.dao;

import com.mabiao.mall.product.entity.CategoryEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品三级分类
 * 
 * @author chenshun
 * @email mabiao0408@gmail.com
 * @date 2021-12-23 14:33:22
 */
@Mapper
public interface CategoryDao extends BaseMapper<CategoryEntity> {
	
}

package com.mabiao.mall.ware.dao;

import com.mabiao.mall.ware.entity.WareSkuEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 商品库存
 * 
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-27 11:08:10
 */
@Mapper
public interface WareSkuDao extends BaseMapper<WareSkuEntity> {
	
}

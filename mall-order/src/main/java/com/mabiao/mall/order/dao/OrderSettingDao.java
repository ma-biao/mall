package com.mabiao.mall.order.dao;

import com.mabiao.mall.order.entity.OrderSettingEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单配置信息
 * 
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-27 10:54:49
 */
@Mapper
public interface OrderSettingDao extends BaseMapper<OrderSettingEntity> {
	
}

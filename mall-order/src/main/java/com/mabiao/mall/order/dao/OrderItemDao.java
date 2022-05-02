package com.mabiao.mall.order.dao;

import com.mabiao.mall.order.entity.OrderItemEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单项信息
 */
@Mapper
public interface OrderItemDao extends BaseMapper<OrderItemEntity> {
	
}

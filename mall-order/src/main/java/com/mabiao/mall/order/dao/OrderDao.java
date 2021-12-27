package com.mabiao.mall.order.dao;

import com.mabiao.mall.order.entity.OrderEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 订单
 * 
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-27 10:54:49
 */
@Mapper
public interface OrderDao extends BaseMapper<OrderEntity> {
	
}

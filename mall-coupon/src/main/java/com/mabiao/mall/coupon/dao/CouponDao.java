package com.mabiao.mall.coupon.dao;

import com.mabiao.mall.coupon.entity.CouponEntity;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
 * 优惠券信息
 * 
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-27 10:23:23
 */
@Mapper
public interface CouponDao extends BaseMapper<CouponEntity> {
	
}

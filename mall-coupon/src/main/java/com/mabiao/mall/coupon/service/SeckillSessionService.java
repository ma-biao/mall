package com.mabiao.mall.coupon.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabiao.common.utils.PageUtils;
import com.mabiao.mall.coupon.entity.SeckillSessionEntity;

import java.util.List;
import java.util.Map;

/**
 * 秒杀活动场次
 *
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-27 10:23:23
 */
public interface SeckillSessionService extends IService<SeckillSessionEntity> {

    PageUtils queryPage(Map<String, Object> params);

    List<SeckillSessionEntity> getLates3DaySession();
}


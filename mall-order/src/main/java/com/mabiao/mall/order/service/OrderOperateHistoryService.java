package com.mabiao.mall.order.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabiao.mall.order.entity.OrderOperateHistoryEntity;
import com.mabiao.common.utils.PageUtils;

import java.util.Map;

/**
 * 订单操作历史记录
 */
public interface OrderOperateHistoryService extends IService<OrderOperateHistoryEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


package com.mabiao.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabiao.common.to.OrderTo;
import com.mabiao.common.to.mq.StockLockedTo;
import com.mabiao.common.utils.PageUtils;
import com.mabiao.mall.ware.entity.WareSkuEntity;
import com.mabiao.mall.ware.vo.SkuHasStockVo;
import com.mabiao.mall.ware.vo.WareSkuLockVo;

import java.util.List;
import java.util.Map;

/**
 * 商品库存
 *
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-27 11:08:10
 */
public interface WareSkuService extends IService<WareSkuEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void addStock(Long skuId, Long wareId, Integer skuNum);

    List<SkuHasStockVo> getSkusHasStock(List<Long> skuIds);

    /**
     * 锁定库存
     */
    boolean orderLockStock(WareSkuLockVo vo);


    /**
     * 解锁库存
     */
    void unlockStock(StockLockedTo to);

    /**
     * 解锁订单
     */
    void unlockStock(OrderTo orderTo);
}


package com.mabiao.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabiao.common.utils.PageUtils;
import com.mabiao.mall.ware.entity.WareInfoEntity;
import com.mabiao.mall.ware.vo.FareVo;

import java.util.Map;

/**
 * 仓库信息
 *
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-27 11:08:10
 */
public interface WareInfoService extends IService<WareInfoEntity> {

    PageUtils queryPage(Map<String, Object> params);

    FareVo getFare(Long addrId);
}


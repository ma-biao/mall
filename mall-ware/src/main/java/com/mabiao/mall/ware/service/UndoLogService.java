package com.mabiao.mall.ware.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabiao.common.utils.PageUtils;
import com.mabiao.mall.ware.entity.UndoLogEntity;

import java.util.Map;

/**
 * 
 *
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-27 11:08:10
 */
public interface UndoLogService extends IService<UndoLogEntity> {

    PageUtils queryPage(Map<String, Object> params);
}


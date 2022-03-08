package com.mabiao.mall.product.fallback;

import com.mabiao.common.exception.BizCodeEnum;
import com.mabiao.common.utils.R;
import com.mabiao.mall.product.feign.SeckillFeignService;
import org.springframework.stereotype.Component;

@Component
public class SeckillFeignServiceFallBack implements SeckillFeignService {
    @Override
    public R getSkuSeckilInfo(Long skuId) {
        return R.error(BizCodeEnum.TO_MANY_REQUEST.getCode(),BizCodeEnum.TO_MANY_REQUEST.getMsg());
    }
}

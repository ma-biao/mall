package com.mabiao.mall.product.feign;

import com.mabiao.common.to.SkuReductionTo;
import com.mabiao.common.to.SpuBoundTo;
import com.mabiao.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient("mall-coupon")
public interface CouponFeignService {
    /**
     * 1. RequestBody 将对象转为Json
     * 2. 找到mall-coupon服务，给/coupon/spubounds/save发送请求；
     *    将上一步转化的json置于请求体位置，发送请求
     * 3. 对方服务收到请求，请求体里面有Json数据
     *    (@RequestBody SpuBoundsEntity spuBounds) 将请求体的Json转为SpuBoundsEntity
     * 只要Json数据模型是兼容的，双方服务无需使用同一个To
     */
    @PostMapping("/coupon/spubounds/save")
    R saveSpuBounds(@RequestBody SpuBoundTo spuBoundTo);

    @PostMapping("/coupon/skufullreduction/saveinfo")
    R saveSkuReduction(@RequestBody SkuReductionTo skuReductionTo);
}

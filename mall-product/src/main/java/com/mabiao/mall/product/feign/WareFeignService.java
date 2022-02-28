package com.mabiao.mall.product.feign;

import com.mabiao.common.to.SkuHasStockVo;
import com.mabiao.common.utils.R;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@FeignClient("mall-ware")
public interface WareFeignService {
    /**
     * 返回结果中含有ware服务的vo
     * 1. R设计的时候可以加上泛型（此种方法需要修改之前所有的controller）
     * 2. 直接返回我们想要的结果（getSkuHasStock不返回R，而是List<SkuHasStockVo>）
     * 3. 自己封装解析结果
     */
    @PostMapping("/ware/waresku/hasstock")
    R getSkuHasStock(@RequestBody List<Long> skuIds);
}

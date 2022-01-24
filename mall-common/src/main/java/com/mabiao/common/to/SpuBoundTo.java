package com.mabiao.common.to;

import lombok.Data;

import java.math.BigDecimal;

/**
 * 数据传输对象
 * 不同服务之间传输数据，数据示例化所需要的对象都封装在To中
 */

@Data
public class SpuBoundTo {
    private Long spuId;
    private BigDecimal buyBounds;
    private BigDecimal growBounds;
}

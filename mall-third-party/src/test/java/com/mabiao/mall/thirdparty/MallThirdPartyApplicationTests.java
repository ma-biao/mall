package com.mabiao.mall.thirdparty;

import com.mabiao.mall.thirdparty.component.SmsComponent;
import com.mabiao.mall.thirdparty.component.SmsNewComponent;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class MallThirdPartyApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    SmsNewComponent smsNewComponent;


}

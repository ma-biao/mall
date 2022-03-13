package com.mabiao.mall.thirdparty.controller;

import com.mabiao.common.utils.R;
import com.mabiao.mall.thirdparty.component.SmsNewComponent;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SmsSendController {
    @Autowired
    private SmsNewComponent smsNewComponent;

    @Value("${spring.cloud.alicloud.access-key}")
    private String accessKeyId;

    @Value("${spring.cloud.alicloud.secret-key}")
    private String accessKeySecret;

    @Value("${spring.cloud.alicloud.sms.signName}")
    private String signName;

    @Value("${spring.cloud.alicloud.sms.templateCode}")
    private String templateCode;

    /**
     * 提供给别的服务进行调用
     */
    @GetMapping(value = "/sms/sendCode")
    public R sendCode(@RequestParam("phone") String phone, @RequestParam("code") String code) throws Exception {

        //发送验证码
        smsNewComponent.sendCode(phone, code, accessKeyId, accessKeySecret,
                signName, templateCode);

        return R.ok();
    }
}

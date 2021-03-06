package com.mabiao.mall.authserver.controller;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import com.mabiao.common.vo.MemberResponseVo;
import com.mabiao.common.utils.HttpUtils;
import com.mabiao.common.utils.R;
import com.mabiao.mall.authserver.feign.MemberFeignService;
import com.mabiao.mall.authserver.vo.SocialUser;
import lombok.extern.slf4j.Slf4j;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Map;

import static com.mabiao.common.constant.AuthServerConstant.LOGIN_USER;

@Slf4j
@Controller
public class OAuth2Controller {
    @Autowired
    private MemberFeignService memberFeignService;


    @GetMapping(value = "/oauth2.0/gitee/success")
    public String weibo(@RequestParam("code") String code, HttpSession session) throws Exception {

        Map<String, String> map = new HashMap<>();
        map.put("client_id","247854d48297f3e6aea2ee322ec69800f80493f87951e95e071570f08e97904d");
        map.put("client_secret","a632a4d13c99c0defe3bcb8048e3461edab18a4090de667d0cc1f68acf5ef23e");
        map.put("grant_type","authorization_code");
        map.put("redirect_uri","http://auth.gulimall.com/oauth2.0/gitee/success");
        map.put("code",code);

        //1、根据用户授权返回的code换取access_token
        HttpResponse response = HttpUtils.doPost("https://gitee.com", "/oauth/token", "post", new HashMap<>(), map, new HashMap<>());

        //2、处理
        if (response.getStatusLine().getStatusCode() == 200) {
            String json = EntityUtils.toString(response.getEntity());
            JSONObject jsonObject = JSON.parseObject(json);
            //获取到了access_token, 使用access_token查询用户信息
            // 注意此处第一次查询返回的信息缺少uid信息，需要使用https://gitee.com/api/v5/user接口
            // 查询用户详细信息确定uid，否则无法判断是否为新用户
            Map<String,String> query = new HashMap<>();
            query.put("access_token", jsonObject.getString("access_token"));
            HttpResponse response2 = HttpUtils.doGet("https://gitee.com", "/api/v5/user", "get", new HashMap<String, String>(), query);
            if (response2.getStatusLine().getStatusCode() != 200) {
                System.out.println("登录状态码: " + response2.getStatusLine().getStatusCode());
                return "redirect:http://auth.gulimall.com/login.html";
            }

            SocialUser socialUser = JSON.parseObject(json, SocialUser.class);
            JSONObject jsonObject2 = JSON.parseObject(EntityUtils.toString(response2.getEntity()));
            socialUser.setUid(jsonObject2.getString("id"));
            //知道了哪个社交用户
            //1）、当前用户如果是第一次进网站，自动注册进来（为当前社交用户生成一个会员信息，以后这个社交账号就对应指定的会员）
            //登录或者注册这个社交用户
            System.out.println(socialUser.getAccess_token());
            //调用远程服务
            R oauthLogin = memberFeignService.oauthLogin(socialUser);
            if (oauthLogin.getCode() == 0) {
                MemberResponseVo data = oauthLogin.getData("data", new TypeReference<MemberResponseVo>() {});
                log.info("登录成功：用户信息：{}",data.toString());

                //1、第一次使用session，命令浏览器保存卡号，JSESSIONID这个cookie
                //以后浏览器访问哪个网站就会带上这个网站的cookie
                //TODO 1、默认发的令牌。当前域（解决子域session共享问题）
                //TODO 2、使用JSON的序列化方式来序列化对象到Redis中
                session.setAttribute(LOGIN_USER,data);

                //2、登录成功跳回首页
                return "redirect:http://gulimall.com";
            } else {
                System.out.println("登录不成功: " + oauthLogin.getCode());
                return "redirect:http://auth.gulimall.com/login.html";
            }

        } else {
            System.out.println("登录状态码: " + response.getStatusLine().getStatusCode());
            return "redirect:http://auth.gulimall.com/login.html";
        }

    }
}

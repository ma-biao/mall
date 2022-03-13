package com.mabiao.mall.member.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.mabiao.common.utils.PageUtils;
import com.mabiao.mall.member.entity.MemberEntity;
import com.mabiao.mall.member.exception.PhoneException;
import com.mabiao.mall.member.exception.UsernameException;
import com.mabiao.mall.member.vo.MemberUserLoginVo;
import com.mabiao.mall.member.vo.MemberUserRegisterVo;
import com.mabiao.mall.member.vo.SocialUser;

import java.util.Map;

/**
 * 会员
 *
 * @author mabiao
 * @email mabiao0408@gmail.com
 * @date 2021-12-27 10:41:30
 */
public interface MemberService extends IService<MemberEntity> {

    PageUtils queryPage(Map<String, Object> params);

    void register(MemberUserRegisterVo vo);

    /**
     * 判断邮箱是否重复
     */
    void checkPhoneUnique(String phone) throws PhoneException;

    /**
     * 判断用户名是否重复
     */
    void checkUserNameUnique(String userName) throws UsernameException;

    /**
     * 用户登录
     */
    MemberEntity login(MemberUserLoginVo vo);

    /**
     * 社交用户的登录
     */
    MemberEntity socialLogin(SocialUser socialUser) throws Exception;

    /**
     * 微信登录
     */
    MemberEntity wxLogin(String accessTokenInfo);
}

